domain-value
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
public class BankAccountNumber extends LongDV {

    protected BankAccountNumber(Long value) {
        super(value);
    }

    public static BankAccountNumber of(Long value) {
        assert isValid(value) : isNotValidText(value, Id.class);
        return new Id(value);
    }

    public static boolean isValid(Long value) {
        return LongDV.isValid(value)
                && value > 0;
    }

    public static BankAccountNumber of(String stringValue) {
        Long value = Long_of(stringValue);
        return of(value);
    }

    public static boolean isValid(String stringValue) {
        if(Long_isValid(stringValue)){
            Long value = Long_of(stringValue);
            return isValid(value);
        }
        return false;
    }

}
```

### comming soon...
* Hibernate UserTypes 
