# domain-value #
[![Build Status](https://travis-ci.org/qoomon/domain-value.svg?branch=master)](https://travis-ci.org/qoomon/domain-value) [![Dependency Status](https://www.versioneye.com/user/projects/5605568af5f2eb001a000fd6/badge.svg?style=flat)](https://www.versioneye.com/user/projects/5605568af5f2eb001a000fd6) [![Maven Central](https://img.shields.io/maven-central/v/com.qoomon/domainvalue.svg)](http://search.maven.org/#search%7Cgav%7C1%7Cg%3A%22com.qoomon%22%20AND%20a%3A%22domainvalue%22)
============
Maven Dependency
```xml
<dependency>
    <groupId>com.qoomon</groupId>
    <artifactId>domainvalue</artifactId>
    <version>LATEST</version>
</dependency>
```
Example: BankAccountNumber

```java
import com.qoomon.domainvalue.type.LongDV;

public class BankAccount extends LongDV {

    protected BankAccount(Long value) {
        super(value);
    }

    @FactoryMethod
    public static BankAccount of(Long value) {
        return new BankAccount(value);
    }

    /**
    * rember to call the super validation method first
    */
    @ValidationMethod
    public static boolean isValid(Long value) {
        return LongDV.isValid(value)
            && value > 1000000;
    }
}
```
