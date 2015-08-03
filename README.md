domain-value [![Build Status](https://travis-ci.org/qoomon/domain-value.svg?branch=develop)](https://travis-ci.org/qoomon/domain-value)
============
Maven Dependency
```xml
<dependency>
    <groupId>com.qoomon</groupId>
    <artifactId>domainvalue</artifactId>
    <version>2.0.0</version>
</dependency>
```
Example: BankAccountNumber

```java
import com.qoomon.domainvalue.type.DV;
import com.qoomon.domainvalue.type.LongDV;

public class BankAccount extends LongDV {

    protected BankAccount(Long value) {
        super(value);
    }

    public static boolean validate(Long value) {
        return DV.validate(value, Long.class, BankAccount.class);
    }

    public static BankAccount of(Long value) {
        return DV.of(value, Long.class, BankAccount.class);
    }

    @Override
    protected boolean isValid(Long value) {
        return super.isValid(value)
                && value > 1000000;
    }
}
```
