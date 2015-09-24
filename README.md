domain-value [![Build Status](https://travis-ci.org/qoomon/domain-value.svg?branch=master)](https://travis-ci.org/qoomon/domain-value)
============
Maven Dependency
```xml
<dependency>
    <groupId>com.qoomon</groupId>
    <artifactId>domainvalue</artifactId>
    <version>3.0.0</version>
</dependency>
```
Example: BankAccountNumber

```java
import com.qoomon.domainvalue.type.LongDV;

public class BankAccount extends LongDV {

    protected BankAccount(Long value) {
        super(value);
    }

    public static BankAccount of(Long value) {
        return new BankAccount(value);
    }

    public static boolean isValid(Long value) {
        return LongDV.isValid(value)
            && value > 1000000;
    }
}
```
