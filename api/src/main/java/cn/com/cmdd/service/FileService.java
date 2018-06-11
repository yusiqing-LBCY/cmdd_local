package cn.com.cmdd.service;




import java.io.InputStream;


import com.aliyun.oss.OSSClient;

import com.aliyun.oss.model.OSSObject;
public class FileService
{

    public  InputStream get(String key){
        //String key = id.toString();
    	InputStream objectContent =null;
    	//byte[] data = {};
        try
        {
            OSSClient ossClient = new OSSClient("oss-cn-beijing.aliyuncs.com", "LTAIcEOlTpzf5WpS", "IFiq9Hc1fp2Ak3dSGrq4a0PeFrFtTc");
            //Date expiration = new Date(new Date().getTime() + PRESIGN_URL_MAX_EXPIRATION_SECONDS * 2000) ;
            //GeneratePresignedUrlRequest req = new GeneratePresignedUrlRequest("cmdd-update", key, HttpMethod.GET);
            //req.setExpiration(expiration);
            OSSObject object = ossClient.getObject("cmdd-update", key);
            // 获取ObjectMeta
            //ObjectMetadata meta = object.getObjectMetadata();

            // 获取Object的输入流
            objectContent = object.getObjectContent();
        
           /*s*/

            // 关闭流
            //objectContent.close();
            

            //ossClient.shutdown();

            return objectContent;

        } catch (Exception e)
        {
            e.printStackTrace();
        }

        return objectContent;
    }
}
