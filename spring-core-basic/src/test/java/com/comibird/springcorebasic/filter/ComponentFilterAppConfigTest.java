package com.comibird.springcorebasic.filter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

public class ComponentFilterAppConfigTest {

  @Test
  void filterScan() {
    // given
    ApplicationContext ac = new AnnotationConfigApplicationContext(ComponentFilterAppConfig.class);

    // when
    BeanA beanA = ac.getBean("beanA", BeanA.class);

    // then
    assertThat(beanA).isNotNull();
    assertThrows(NoSuchBeanDefinitionException.class,
        () -> ac.getBean("beanB", BeanB.class));
  }

  @Configuration
  @ComponentScan(
      includeFilters = @Filter(type = FilterType.ANNOTATION, classes = MyIncludeComponent.class),
      excludeFilters = @Filter(type = FilterType.ANNOTATION, classes = MyExcludeComponent.class)
  )
  static class ComponentFilterAppConfig {

  }

}
