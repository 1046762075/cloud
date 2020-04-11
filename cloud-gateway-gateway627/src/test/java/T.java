import java.time.ZonedDateTime;

/**
 * <p>Title: T</p>
 * 作用：2020-04-11T20:01:44.175+08:00[Asia/Shanghai]
 * 时间：2020/4/11 20:00
 */
public class T {
	public static void main(String[] args) {
		ZonedDateTime now = ZonedDateTime.now();
		System.out.println(now);
	}
}
