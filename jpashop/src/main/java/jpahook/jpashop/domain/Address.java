package jpahook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class Address {
    private String city;
    private String street;
    private String zipcode;

    protected Address() {
        //JPA에서는 엔티티나 임베디드 타입은 자바 기본 생성자(default constructor) public 또는 protected로 설정하여
        //JPA 구현 라이브러리가 리플랙션 같은 기술을 사용할 수 있도록 지원한다.
    }

    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
