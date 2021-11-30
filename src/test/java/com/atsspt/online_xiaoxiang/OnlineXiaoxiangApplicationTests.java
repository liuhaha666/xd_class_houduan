package com.atsspt.online_xiaoxiang;

import com.atsspt.online_xiaoxiang.model.entity.User;
import com.atsspt.online_xiaoxiang.utils.JWTUtils;
import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootTest
@EnableTransactionManagement
class OnlineXiaoxiangApplicationTests {

	@Test
	public void TestofJwts() {
		User user = new User();
		user.setId(6677);
		user.setName("xdclassss");
		String token = JWTUtils.genJsonWebToken(user);
		System.out.println(token);
		Claims claims = JWTUtils.checkJWT(token);
		System.out.println(claims.get("name"));
	}

}
