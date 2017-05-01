package constantes;

import java.io.File;

public class IConstantesSuperVoices {
	public static final String SECUENCIA_USER = "seq_user";
	public static final String SECUENCIA_ADMINISTRADOR = "seq_administrador";
	public static final String SECUENCIA_CONCURSO = "seq_concurso";
	public static final String SECUENCIA_LOCUTOR = "seq_locutor";
	public static final String SECUENCIA_VOZ = "seq_voz";
	
	
	
    public static final String AWS_S3_BUCKET = "aws.s3.bucket";
    public static final String AWS_ACCESS_KEY = "aws.access.key";
    public static final String AWS_SECRET_KEY = "aws.secret.key";
    public static final String ES_WORKER = "supervoices.is_worker";
    public static final String EMAIL_HOST_USER = "supervoices.email.host.user";
    public static final String EMAIL_HOST_PASSWORD = "supervoices.email.host.password";
    public static final String EMAIL_HOST_NAME = "supervoices.email.host.name";
    public static final String SENDGRID_API_KEY = "supervoices.sendgrid";
    public static final String MEMCACHE_USER = "supervoices.memcache.user";
    public static final String MEMCACHE_PASSWORD = "supervoices.memcache.password";
    public static final String MEMCACHE_ADDRESS = "supervoices.memcache.address";
    
    
    public static final String CARPETA_IMAGENES = "images/";
    public static final String CARPETA_AUDIOS_ORIGINALES = "voces/original/";
    public static final String CARPETA_AUDIOS_CONVERTIDA = "voces/convertida/";
    
    public static final String RUTA_PUBLICA_BUCKET = "https://s3-us-west-2.amazonaws.com/voicessuper/";
    public static final String RUTA_CLOUDFRONT_AUDIOS_CONVERTIDOS = "http://d1atthddiomrp3.cloudfront.net/voces/convertida/";
    
    
    public static final String TIPO_ARCHIVO_IMAGEN = "image";
    public static final String TIPO_ARCHIVO_AUDIO = "audio";
    
    public static final String EXTENSION_MP3 = "mp3";
    
    public static final String ROOT_PATH = System.getProperty("user.home");
    public static final String PATH_ORIGINAL = ROOT_PATH + File.separator + CARPETA_AUDIOS_ORIGINALES;
    public static final String PATH_CONVERTIDA = ROOT_PATH + File.separator + CARPETA_AUDIOS_CONVERTIDA;
    
    
}
