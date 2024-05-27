import redis.clients.jedis.Jedis;
import java.util.List;
import java.util.Set;

public class RedisJava {
   public static void main(String[] args) { 
      //Connecting to Redis server on localhost 
      Jedis jedis = new Jedis("http://127.0.0.1:6379");
      System.out.println("Connection to server sucessfully"); 
      //check whether server is running or not 
      System.out.println("Server is running: "+jedis.ping());
      System.out.println(jedis.get("id"));

      //Список всех ключей
      Set<String> keys = jedis.keys("*");
      keys.stream().forEach(System.out::println);

      //Получить список
      List<String> list = jedis.lrange("NoSQLList", 0 ,10);
      list.stream().forEach(System.out::println);

      //Создать и вывести Hash, Set, SortedSet
      //Создать transaction
   }
} 