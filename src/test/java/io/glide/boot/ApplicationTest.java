package io.glide.boot;

import io.glide.service.impl.UserServiceImplTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = UserServiceImplTest.class)
class ApplicationTest {

  @Test
  void contextLoads() {}
}
