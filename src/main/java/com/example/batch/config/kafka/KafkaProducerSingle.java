//package com.example.batch.config.kafka;
//
//import com.example.batch.util.NetworkUtils;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.kafka.clients.producer.KafkaProducer;
//import org.apache.kafka.clients.producer.Producer;
//import org.apache.kafka.clients.producer.ProducerConfig;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//
//import java.io.IOException;
//import java.time.Duration;
//import java.util.ArrayList;
//import java.util.Map;
//import java.util.Properties;
//
//@Slf4j
//@RequiredArgsConstructor
//@Configuration
//@PropertySource("classpath:kafka.properties")
//public class KafkaProducerSingle {
//
//  @Value("${KAFKA_SERVICE_HOST}")
//  private String KAFKA_SERVICE_HOST;
//  @Value("${KAFKA_KEY_SERIALIZER}")
//  private String KAFKA_KEY_SERIALIZER;
//  @Value("${KAFKA_VALUE_SERIALIZER}")
//  private String KAFKA_VALUE_SERIALIZER;
//  @Value("${KAFKA_SERVER_NAME_TYPE}")
//  private String KAFKA_SERVER_NAME_TYPE;
//  @Value("${KAFKA_SERVICE_SERVER_NO}")
//  private String KAFKA_SERVICE_SERVER_NO;
//  @Value("${KAFKA_COLLECT_SERVER_NO}")
//  private String KAFKA_COLLECT_SERVER_NO;
//
//  private static KafkaProducerSingle INSTANCE;
//  private Producer<String, String> producer;
//  private boolean isActiveProducer = false;
//
//  private void bindProducer() {
//    Properties prop = this.getProperties();
//    producer = new KafkaProducer<>(prop);
//    log.debug("Kafka prop - {}", prop);
//    isActiveProducer = true;
//  }
//
//  private void unbindProducer() {
//    if (isActiveProducer) {
//      isActiveProducer = false;
//      producer.close(Duration.ofSeconds(1));
//      log.debug("kafka producer closed");
//    }
//  }
//
//  // produer 의 경우 null 이 되면 안되고 될수도 없어야함.
//  public Producer<String, String> getProducer() {
//    if (this.producer == null) {
//      Properties props = this.getProperties();
//      this.producer = new KafkaProducer<>(props);
//      log.info("kafka producer restart");
//    }
//    return producer;
//  }
//
//  public void connect() {
//    bindProducer();
//  }
//
//  public Properties getProperties() {
//    Properties props = new Properties();
//    props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, KAFKA_SERVICE_HOST);
//    props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, KAFKA_KEY_SERIALIZER);
//    props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KAFKA_VALUE_SERIALIZER);
//
//    return props;
//  }
//
//  public static KafkaProducerSingle getInstanceBatch() {
//    if (INSTANCE == null) {
//      INSTANCE = new KafkaProducerSingle();
//      INSTANCE.connect();
//    }
//    return INSTANCE;
//  }
//
//  public void send(String topic, Map object, boolean isRetry) {
//    boolean chkHostIp = NetworkUtils.isListInTarget(KAFKA_SERVER_NAME_TYPE, KAFKA_SERVICE_SERVER_NO, ConfigServlet.hostId);
//  }
//
//  public void writeFileWhere(String topic, String object) {
//
//    String KAFKA_COLLECT_SENDING_USERID = PropertyHandler.getProperty("KAFKA_COLLECT_SENDING_USERID");
//    String KAFKA_COLLECT_TOPIC = PropertyHandler.getProperty("KAFKA_COLLECT_TOPIC");
//
//    boolean KAFKA_COLLECT_DATA = PropertyHandler.getBoolean("KAFKA_COLLECT_DATA",false);
//    boolean chkHostIp = NetworkUtils.isListInTarget(KAFKA_SERVER_NAME_TYPE, KAFKA_COLLECT_SERVER_NO, ConfigServlet.hostId);
//    boolean chkTopic = topic.equals(KAFKA_COLLECT_TOPIC);
//
//    log.debug("type - {}, collect - {}, no - {}, hostid - {}, chkHostIp - {}", KAFKA_SERVER_NAME_TYPE, KAFKA_COLLECT_DATA, KAFKA_COLLECT_SERVER_NO, ConfigServlet.hostId, chkHostIp);
//
//    if( KAFKA_COLLECT_DATA && chkHostIp ) {
//      boolean chkUserId = false;
//      ArrayList<String> lists = StringUtils.splitFunction(KAFKA_COLLECT_SENDING_USERID, ",");
//      for (String item : lists) {
//        if (object.contains(item)) {
//          chkUserId = true;
//          break;
//        }
//      }
//
//      logger.debug("chkTopic - {}, chkUserId - {}, id - {}, topic - {}, object - {}", chkTopic, chkUserId, KAFKA_COLLECT_SENDING_USERID, topic, object.substring(0, 10));
//      if( chkTopic ) {
//
//        String writeFileName = String.format("%s_%s", topic, DateUtils.getDate("yyyyMMdd_HH"));
//        if ( "ClickViewData".equals(topic) ) {
//          try {
//            appendStringToFile(PropertyHandler.getProperty("KafkaFileLog") +"/collect/"+ writeFileName
//              , String.format("%s\t%s\t%s\t%s", DateUtils.getDate("yyyy-MM-dd HH:mm:ss"), topic, object, ""));
//          } catch (IOException e1) {}
//        }
//        else if ( "ShopInfoData".equals(topic) ) {
//          try {
//            appendStringToFile(PropertyHandler.getProperty("KafkaFileLog") +"/collect/"+ writeFileName
//              , String.format("%s\t%s\t%s\t%s", DateUtils.getDate("yyyy-MM-dd HH:mm:ss"), topic, object, ""));
//          } catch (IOException e1) {}
//        }
//        else if ( "ShopStatsInfoData".equals(topic) ) {
//          try {
//            appendStringToFile(PropertyHandler.getProperty("KafkaFileLog") +"/collect/"+ writeFileName
//              , String.format("%s\t%s\t%s\t%s", DateUtils.getDate("yyyy-MM-dd HH:mm:ss"), topic, object, ""));
//          } catch (IOException e1) {}
//        }
//        else if ( "ConversionData".equals(topic) ) {
//          try {
//            appendStringToFile(PropertyHandler.getProperty("KafkaFileLog") +"/collect/"+ writeFileName
//              , String.format("%s\t%s\t%s\t%s", DateUtils.getDate("yyyy-MM-dd HH:mm:ss"), topic, object, ""));
//          } catch (IOException e1) {}
//        }
//        else if ( "ExternalData".equals(topic) ) {
//          try {
//            appendStringToFile(PropertyHandler.getProperty("KafkaFileLog") +"/collect/"+ writeFileName
//              , String.format("%s\t%s\t%s\t%s", DateUtils.getDate("yyyy-MM-dd HH:mm:ss"), topic, object, ""));
//          } catch (IOException e1) {}
//        }
//        else {
//          logger.debug("else topic - {}", topic);
//        }
//      }
//    }
//  }
//}
