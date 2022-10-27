package com.rubensgomes.kafka.learning.consumer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.apache.commons.lang3.Validate;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import com.rubensgomes.kafka.learning.producer.ProducerExample;

import lombok.extern.slf4j.Slf4j;

/**
 * Code pulled from Confluent site.
 * 
 * @see <a href="https://developer.confluent.io/get-started/java/">Confluent
 *      Kafka Get Started</a>
 * @author Rubens Gomes
 */
@Slf4j
public class ConsumerExample
{
   public static void main( final String[] args )
      throws Exception
   {
      if( args.length != 1 )
      {
         log.error( "Configuration file argument missing at command line" );
         System.exit( 1 );
      }


      // Load consumer configuration settings from a local file
      final Properties props = ProducerExample.loadConfig( args[0] );
      final String topic = props.getProperty( "topic.name" );
      Validate.notBlank( topic, "Missing topic.name in config file: " + args[0] );

      // Add additional properties.
      props.put( ConsumerConfig.GROUP_ID_CONFIG,
                 "kafka-rubens-consumer" );
      props.put( ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,
                 "earliest" );

      log.debug( "creating consumer..." );
      final Consumer< String, String > consumer = new KafkaConsumer<>( props );

      log.debug( "Consumer subscribing to topic [{}]", topic );
      consumer.subscribe( Arrays.asList( topic ) );

      try
      {

         while( true )
         {
            ConsumerRecords< String, String > records =
               consumer.poll( Duration.ofMillis( 100 ) );

            for( ConsumerRecord< String, String > record : records )
            {
               String key = record.key();
               String value = record.value();
               log.info( "Consumed event from topic [{}] with key [{}] and value [{}]",
                         topic,
                         key,
                         value );
            }

         }
      }
      finally
      {
         log.info( "Closing consumer..." );
         consumer.close();
      }

   }
}
