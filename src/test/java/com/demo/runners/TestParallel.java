package com.demo.runners;

import com.intuit.karate.junit5.Karate;

class TestParallel {

//    @Karate.Test
//    Karate testSample() {
//        return Karate.run("sample").relativeTo(getClass());
//    }
//    
//    @Karate.Test
//    Karate testTags() {
//        return Karate.run("tags").tags("@second").relativeTo(getClass());
//    }

    @Karate.Test
    Karate testSystemProperty() {
        return Karate.run("classpath:Store.feature")
                .tags("@MyStore")
                .systemProperty("foo", "bar");
    }

}