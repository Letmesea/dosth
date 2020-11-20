package com.rabbitmq.rabbitmq.util;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;
@Slf4j
public class YmlUtil {
    public static String getValue(String proFileName, String key) {
        try {
            Yaml yaml = new Yaml();
            //文件路径是相对类目录(src/main/java)的相对路径
//            InputStream in = YmlUtil.class.getClassLoader().getResourceAsStream(proFileName);
            InputStream in = new FileInputStream(proFileName);
            Map<String, Object> map = yaml.loadAs(in, Map.class);
//            String appid = map.getOrDefault("appid", "123").toString();
//            System.out.println(appid);
            String [] keys = key.split("\\.");
            Map<String, Object> map1=null;
            if(keys.length>1){
                int i=0;
                for(;i<keys.length;i++){
                    map1 = (Map<String, Object>)map.get(keys[i]);
                    map = map1;
                    if(i==keys.length-2) break;
                }
                return map1.get(keys[i+1]).toString();
            }else{
                return map.get(key).toString();
            }
        } catch (Exception e) {
            log.error("根据键值(KEY)获取对应的值 IO异常信息", e);

        }
        return null;
    }
    public static void main(String[] args){
        String a = getValue("application-dev.yml","name.age");
        log.info("结果："+a);
    }
}
