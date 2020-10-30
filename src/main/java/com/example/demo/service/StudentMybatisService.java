package com.example.demo.service;

import com.example.demo.entity.Student;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.List;

@CacheConfig(cacheNames = "student")
public interface StudentMybatisService {
    int add(Student student);

    /*
    @CachePut：主要针对方法的配置，能够根据方法的请求参数对其结果进行缓存，和@Cacheable不同的是，它每次都会触发真实方法的调用。
    */
    // #p0代表注解的函数接收的第一个参数
    // 这里#p0代表student
    @CachePut(key = "#p0.sno")
    Student update(Student student);

    /*
    @CacheEvict：主要对方法配置，用来标记要清空缓存的方法，当这个方法被调用并满足一定条件后，即会清空缓存。
    参数解析：
    value：缓存的位置，不能为空。
    key：缓存的key，默认为空。
    condition：触发的条件，只有满足条件的情况才会清楚缓存，默认为空，支持SpEL。
    allEntries：true表示清除value中的全部缓存，默认为false。
    */
    // 这里#p0代表sno
    @CacheEvict(key = "#p0", allEntries = true)
    int deleteBysno(String sno);

    /*
    @Cacheable：主要用来配置方法，能够根据方法的请求参数对其结果进行缓存。即当重复使用相同参数调用方法的时候，方法本身不会被调用执行，即方法本身被略过了，取而代之的是方法的结果直接从缓存中找到并返回了。
    参数介绍：
    value：缓存的名字，必须指定至少一个。
    key:缓存的key，可以为空，如果指定要按照SpEL表达式编写；如果不指定，则缺省按照方法的所有参数进行组合。
    condition：缓存的条件，可以为空，使用SpEL编写，返回true或者false，只有为true才能缓存。
    */
    // 这里#p0代表sno
    @Cacheable(key = "#p0")
    Student queryStudentBySno(String sno);

    // @Cacheable(key = "#p0")
    List<Student> queryAllStudent();
}
