public class UserAccountNotFoundException extends Exception {
    public UserAccountNotFoundException(String message) {
        super(message); // 부모 클래스의 생성자 호출
    }
}
