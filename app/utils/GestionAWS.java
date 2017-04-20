package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.elasticache.AmazonElastiCache;
import com.amazonaws.services.elasticache.AmazonElastiCacheClient;
import com.amazonaws.services.elasticache.model.CacheCluster;
import com.amazonaws.services.elasticache.model.CacheNode;
import com.amazonaws.services.elasticache.model.DescribeCacheClustersRequest;
import com.amazonaws.services.elasticache.model.DescribeCacheClustersResult;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CopyObjectRequest;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClient;
import com.amazonaws.services.sqs.model.CreateQueueRequest;
import com.amazonaws.services.sqs.model.CreateQueueResult;
import com.amazonaws.services.sqs.model.DeleteMessageRequest;
import com.amazonaws.services.sqs.model.GetQueueAttributesRequest;
import com.amazonaws.services.sqs.model.GetQueueAttributesResult;
import com.amazonaws.services.sqs.model.GetQueueUrlResult;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.QueueDoesNotExistException;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import com.amazonaws.services.sqs.model.ReceiveMessageResult;
import com.amazonaws.services.sqs.model.SendMessageRequest;

import constantes.IConstantesSuperVoices;
import play.Configuration;
import play.Logger;

public class GestionAWS {
	private String accessKey;
	private String secretKey;
	private String s3Bucket;
	private boolean conectado;
	private AmazonS3Client amazonS3;
	private String folderPublico;
	private static AWSCredentials awsCredentials;

	public GestionAWS() {

	}

	private static AWSCredentials conexion(){
		String accessKey = Configuration.root().getString(IConstantesSuperVoices.AWS_ACCESS_KEY);
		String secretKey = Configuration.root().getString(IConstantesSuperVoices.AWS_SECRET_KEY);
		return new BasicAWSCredentials(accessKey, secretKey);
	}


	public String subirArchivoAS3(File file, String nomArchivo, String valUrl, String contentType, boolean esAudio){
		awsCredentials = conexion();
		amazonS3 = new AmazonS3Client(awsCredentials);
		conectado = true;
		if(conectado){
			try {
				this.s3Bucket = Configuration.root().getString(IConstantesSuperVoices.AWS_S3_BUCKET);
				FileInputStream input;

				input = new FileInputStream(file);

				ObjectMetadata metaData = new ObjectMetadata();

				metaData.setContentType(contentType);
				metaData.setContentLength(file.length());


				String folderContenedor = esAudio ? IConstantesSuperVoices.CARPETA_AUDIOS_ORIGINALES : IConstantesSuperVoices.CARPETA_IMAGENES;
				String[] extension = nomArchivo.split("\\.");
				String nomArchivoFinal = valUrl + "." + extension[1];
				//PutObjectRequest putObjectRequest = new PutObjectRequest(s3Bucket, folderContenedor + nomArchivoFinal, file);
				amazonS3.putObject(s3Bucket,folderContenedor + nomArchivoFinal,input,metaData);
				//.putObject(putObjectRequest);
				return IConstantesSuperVoices.RUTA_PUBLICA_BUCKET + folderContenedor + nomArchivoFinal;
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return folderPublico;
	}

	public String subirArchivoConvertido(File file, String nomArchivoFinal, String contentType){
		Logger.info("Empieza a subir el archivo convertido a S3");
		
		awsCredentials = conexion();
		amazonS3 = new AmazonS3Client(awsCredentials);
		this.s3Bucket = Configuration.root().getString(IConstantesSuperVoices.AWS_S3_BUCKET);

		try {
			FileInputStream input;


			input = new FileInputStream(file);


			ObjectMetadata metaData = new ObjectMetadata();

			metaData.setContentType(contentType);
			metaData.setContentLength(file.length());
			amazonS3.putObject(s3Bucket,IConstantesSuperVoices.CARPETA_AUDIOS_CONVERTIDA + nomArchivoFinal,input,metaData);
			

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return IConstantesSuperVoices.RUTA_CLOUDFRONT_AUDIOS_CONVERTIDOS + nomArchivoFinal;
	}


	public String descargarAudio(String nomArchivo){
		awsCredentials = conexion();
		amazonS3 = new AmazonS3Client(awsCredentials);
		this.s3Bucket = Configuration.root().getString(IConstantesSuperVoices.AWS_S3_BUCKET);
		GetObjectRequest objectRequest = new GetObjectRequest(s3Bucket,IConstantesSuperVoices.CARPETA_AUDIOS_ORIGINALES + nomArchivo);
		ObjectMetadata audio = amazonS3.getObject(objectRequest, new File(IConstantesSuperVoices.PATH_ORIGINAL + nomArchivo));
		return objectRequest.getKey();
	}

	public void copiarAudioARutaConvertidas(String nomAudio){
		awsCredentials = conexion();
		amazonS3 = new AmazonS3Client(awsCredentials);
		this.s3Bucket = Configuration.root().getString(IConstantesSuperVoices.AWS_S3_BUCKET);

		Logger.info("Se copiará el audio mp3 de " + IConstantesSuperVoices.CARPETA_AUDIOS_ORIGINALES + nomAudio + " a " + IConstantesSuperVoices.CARPETA_AUDIOS_CONVERTIDA + nomAudio);
		amazonS3.copyObject(this.s3Bucket,IConstantesSuperVoices.CARPETA_AUDIOS_ORIGINALES + nomAudio, this.s3Bucket, IConstantesSuperVoices.CARPETA_AUDIOS_CONVERTIDA + nomAudio);
	}

	public void sesionElastiCache(){
		AmazonElastiCache elasticacheClient = new AmazonElastiCacheClient(awsCredentials);
		conectado = true;
		if(conectado){
			elasticacheClient.setEndpoint("svoicescache.8a0i5o.cfg.usw2.cache.amazonaws.com:11211");


			List<String> endpoints = new ArrayList<String>();
			DescribeCacheClustersRequest request = new DescribeCacheClustersRequest();
			request.setShowCacheNodeInfo(true);
			request.setCacheClusterId("svoicescache");
			DescribeCacheClustersResult result = elasticacheClient.describeCacheClusters(request);
			List<CacheCluster> clusters = result.getCacheClusters();
			for (CacheCluster cluster : clusters) {
				List<CacheNode> nodes = cluster.getCacheNodes();
				for (CacheNode node : nodes) {
					System.out.println(node.getEndpoint().getAddress());
					endpoints.add(node.getEndpoint().getAddress());
				}
			}


		}
	}


	public static class SQS
	{
		private static String queueName = "SVoicesQueue";
		private static String queueUrl;
		private static AmazonSQS sqs;
		private List<Message> messages;

		private SQS(String queueName)
		{
			if (sqs == null)
			{
				awsCredentials = conexion();
				sqs = new AmazonSQSClient(conexion());
				Region usWest2 = Region.getRegion(Regions.US_WEST_2);
				sqs.setRegion(usWest2);

			}


			// Si es un nuevo nombre de cola
			if (!Objects.equals(SQS.queueName, queueName))
			{
				SQS.queueName = queueName;
				queueUrl = null;
			}

			if (queueUrl == null || queueUrl.isEmpty())
			{
				try
				{
					// Obtener cola en AWS
					GetQueueUrlResult queueUrlResult = sqs.getQueueUrl(queueName);
					queueUrl = queueUrlResult.getQueueUrl();
				}
				catch (QueueDoesNotExistException e)
				{
					//Si la cola no existe, crearla
					CreateQueueRequest createQueueRequest = new CreateQueueRequest(queueName);
					CreateQueueResult createQueueResult = sqs.createQueue(createQueueRequest);
					queueUrl = createQueueResult.getQueueUrl();
				}
			}

		}

		public SQS()
		{
			this(queueName);
		}

		public void createMessage(String message)
		{
			sqs.sendMessage(new SendMessageRequest(queueUrl, message));
		}

		public List<Message> getMessages()
		{
			return messages;
		}

		public List<Message> requestMessages(int messages)
		{
			ReceiveMessageRequest receiveMessageRequest = new ReceiveMessageRequest(queueUrl);
			receiveMessageRequest.setMaxNumberOfMessages(messages);

			ReceiveMessageResult receiveMessageResult = sqs.receiveMessage(receiveMessageRequest);
			this.messages = receiveMessageResult.getMessages();
			return getMessages();
		}

		public String getNumberOfMessages()
		{
			final String totalMessages = "ApproximateNumberOfMessages";
			ArrayList<String> attributes = new ArrayList<>();
			attributes.add(totalMessages);

			GetQueueAttributesResult queueAttributesResult = sqs.getQueueAttributes(new GetQueueAttributesRequest(queueUrl));
			return queueAttributesResult.getAttributes().get(totalMessages);
		}

		public void deleteMessage(Message message)
		{
			String messageReceiptHandle = message.getReceiptHandle();
			sqs.deleteMessage(new DeleteMessageRequest(queueUrl, messageReceiptHandle));
		}

	}	



}	



