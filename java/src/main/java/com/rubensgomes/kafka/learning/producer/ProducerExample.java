package com.rubensgomes.kafka.learning.producer;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

import org.apache.commons.lang3.Validate;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import lombok.extern.slf4j.Slf4j;

/**
 * Code pulled from Confluent site.
 * 
 * @see <a href="https://developer.confluent.io/get-started/java/">Confluent
 *      Kafka Get Started</a>
 * @author Rubens Gomes
 */
@Slf4j
public class ProducerExample
{
   public static void main( final String[] args )
   {
      if( args.length != 1 )
      {
         log.error( "Configuration file argument missing at command line" );
         System.exit( 1 );
      }

      // Load producer configuration settings from a local file
      final Properties props = loadConfig( args[0] );
      final String topic = props.getProperty( "topic.name" );
      Validate.notBlank( topic,
                         "Missing topic.name in config file: " + args[0] );

      String[][] keyValues = { { "rubens",
                                 "computer" },
                               { "luciana",
                                 "seweing machine" },
                               { "mateus",
                                 "iphone" } };
      log.debug( "Instantiating a KafkaProducer..." );
      Producer< String, String > producer = null;

      try
      {
         producer = new KafkaProducer<>( props );

         for( String[] keyValue : keyValues )
         {
            String key = keyValue[0];
            String value = keyValue[1];

            log.debug( "Submiting event to topic [{}] for key [{}] with value [{}]",
                       topic,
                       key,
                       value );
            ProducerRecord< String, String > record =
               new ProducerRecord<>( topic,
                                     key,
                                     value );
            log.debug( "ProducerRecord [{}]",
                       record );

            //@formatter:off
            producer.send( record,
                           ( event, ex ) ->
               {
                  if( ex != null )
                  {
                     log.error( "Error while dispatching event to topic [{}]: {}",
                                topic,
                                ex.getMessage(),
                                ex );
                  }
                  else
                     log.info( "Produced event to topic [{}] with event key [{}] and value [{}]",
                               topic,
                               key,
                               value );
               }
            );
            //@formatter:on
         }

      }
      finally
      {

         if( producer != null )
         {
            producer.flush();
            log.info( "{} events produced to topic {}\n",
                      keyValues.length,
                      topic );
            producer.close();
         }

      }

   }

   /**
    * We'll reuse this function to load properties from the Consumer as well
    */
   public static Properties loadConfig( final String configFile )
   {
      if( !Files.exists( Paths.get( configFile ) ) )
      {
         log.error( "Configuration file {} not found",
                    configFile );
         throw new IllegalArgumentException( configFile + " not found." );
      }

      log.debug( "Loading properties from: {}",
                 configFile );
      final Properties cfg = new Properties();
      InputStream inputStream = null;

      try
      {
         inputStream = new FileInputStream( configFile );
         cfg.load( inputStream );
      }
      catch( IOException ex )
      {
         log.error( "Failed to load properties from [{}]: {}",
                    configFile,
                    ex.getMessage() );
         throw new IllegalArgumentException( "Failed to load config file",
                                             ex );
      }
      finally
      {

         if( inputStream != null )
         {
            try
            {
               inputStream.close();
            }
            catch( IOException ex )
            {
               log.debug( "Failed to close input stream: {}",
                          ex.getMessage() );
            }
         }

      }

      log.debug( "Loaded properties: {}",
                 cfg.toString() );
      return cfg;
   }
}
