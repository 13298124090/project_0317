import redis.clients.jedis.Jedis;

public class jedis {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.2.202", 6379);
        String ping = jedis.ping();

        System.out.println(ping);

//πÿ±’¡¨Ω”
        jedis.close();
    }
}
