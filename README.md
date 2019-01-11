# `Testing`

## Beispiel 
**Beschreibung**

Ein Program mit einer Entity User, mit Passwort und Username. Das wird verwaltet von einem EntityManager ohne Datenbank.
Und dazu noch eine Verify Klasse, die die Validation vom Passwort überprüft.
Für dieses Program schreiben wir dann Tests mit Mockito und Junit5.
****
**pom.xml**

Junit5

```
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-api</artifactId>
    <version>5.3.2</version>
    <scope>test</scope>
</dependency>
<dependency>
    <groupId>org.junit.platform</groupId>
    <artifactId>junit-platform-runner</artifactId>
    <version>1.3.2</version>
    <scope>test</scope>
</dependency>
<dependency>
    <groupId>org.junit.vintage</groupId>
    <artifactId>junit-vintage-engine</artifactId>
    <version>5.3.2</version>
    <scope>test</scope>
</dependency>

```

Mockito

```
<dependency>
    <groupId>org.mockito</groupId>
    <artifactId>mockito-core</artifactId>
    <version>2.23.4</version>
    <scope>test</scope>
</dependency>

```
****
**Entity**

User

```java
public class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
```
****
**EntityManager**

```java
public class EntityManager {

    private List<User> userList;
    private Verify verify;

    public EntityManager(Verify verify){
        userList = new ArrayList<User>();
        this.verify = verify;
    }

    public boolean addUser(String username, String password){
        if(verify.verifyPassword(password)){
            User user = new User(username, password);
            userList.add(user);
            return true;
        }
        return false;
    }

}
```
****
**Verify**

```
public class Verify {

    public boolean verifyPassword(String password){
        if(password.length() < 6){
            return false;
        }
        return true;
    }
}

```
****
**Tests**

Es sind Tests für verifyPassword und addUser zuschreiben. Dabei soll beachtet werden das mit einem Test, nur eine Methode getestet wird. Um das zu lösen brauchen Sie Mockito.

****
**Quellen**

[Junit](http://www.vogella.com/tutorials/JUnit/article.html)

[Mockito](http://www.vogella.com/tutorials/Mockito/article.html)