package utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.elasticache.AmazonElastiCache;
import com.amazonaws.services.elasticache.AmazonElastiCacheClient;
import com.amazonaws.services.elasticache.model.CacheCluster;
import com.amazonaws.services.elasticache.model.CacheNode;
import com.amazonaws.services.elasticache.model.DescribeCacheClustersRequest;
import com.amazonaws.services.elasticache.model.DescribeCacheClustersResult;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

import constantes.IConstantesSuperVoices;
import play.Configuration;

public class GestionAWS {
	private String accessKey;
	private String secretKey;
	private String s3Bucket;
	private boolean conectado;
	private AmazonS3Client amazonS3;
	private String folderPublico;
	private AWSCredentials awsCredentials;

	public GestionAWS() {
		conexion();		
	}

	private void conexion(){
		this.accessKey = Configuration.root().getString(IConstantesSuperVoices.AWS_ACCESS_KEY);
		this.secretKey = Configuration.root().getString(IConstantesSuperVoices.AWS_SECRET_KEY);
		if ((accessKey != null) && (secretKey != null)) {
		awsCredentials = new BasicAWSCredentials(accessKey, secretKey);
		}
	}


	public String subirArchivoAS3(File file, String nomArchivo, String valUrl, String contentType, boolean esAudio){
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
}	
