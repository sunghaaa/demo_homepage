package com.example.demo_homepage;

import com.example.demo_homepage.domain.entity.TestEntity;
import com.example.demo_homepage.repository.TestRepository;
import com.example.demo_homepage.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@SpringBootTest
@Rollback(value = false)
@ExtendWith(SpringExtension.class)
public class DbTest {

    @Autowired
    TestRepository testRepository;

    @Autowired
    UserRepository userRepository;

    @Test
    @Transactional
    void dbTest() throws Exception {
        TestEntity testEntity = new TestEntity();
        testEntity.setText("text");

        Long saveId = testRepository.save(testEntity);
        TestEntity findEntity = testRepository.find(saveId);

        Assertions.assertThat(findEntity.getId()).isEqualTo(testEntity.getId());
        Assertions.assertThat(findEntity.getText()).isEqualTo(testEntity.getText());

    }

    @Test
    @Transactional
    void test() throws Exception {
        TestEntity test = new TestEntity();
        test.setText("text");

        TestEntity save = userRepository.save(test);
        Optional<TestEntity> find = userRepository.findById(save.getId());

        Assertions.assertThat(find.isPresent()).isTrue();
        Assertions.assertThat(find.get().getText()).isEqualTo(test.getText());
    }
}
