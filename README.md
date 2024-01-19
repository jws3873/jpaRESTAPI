# REST API 프로젝트

## 👨‍🏫REST API란
출처: https://velog.io/@somday/RESTful-API-%EC%9D%B4%EB%9E%80

출처: [https://velog.io/@somday/RESTful-API-%EC%9D%B4%EB%9E%80](https://lifere.tistory.com/entry/Spring-Boot-REST-API-CRUD-%EA%B5%AC%ED%98%84)
* REST API 에서 REST는 Representational State Transfer의 약자로 소프트웨어 프로그램 아키텍처의 한 형식이다.
* 즉, 자원을 이름(자원의표현) 으로 구분하여 해당 자원의 상태(정보)를 주고받는 모든것을 의미힌다.
* 월드 와이드 웹(WWWW) 과 같은 분산 파이퍼 미디어 시슽엠을 위한 소프트웨어 개발 아키텍처의 한 형식
* REST는 기본적으로 웹의 기존 기술과 HTTP 프로토콜을 그대로 활용하기 때문에 웹의 장점을 최대한 활용할 수 있는 아키텍처 스타일이다.

## REST의 구체적인 개념
* HTTP URL를 통해 자원을 명시하고, HTTP Method(POST, GET, PUT, DELETE)를 통해 해당 자원에 대한 CRUD OPERATION을 적용하는 것을 의미한다.
* 즉, REST는 자원 기반의 구조(ROA: Resource Oriented Architecture) 설계의 중심에 Resource가 있고 HTTP Method를 통해 Resource를 처리하도록 설계된 아키텍쳐를 의미한다.

## HTTP METHOD의 알맞은 역할
* POST : POST를 통해 해당 URL를 요청하면 리소스를 생성한다.
* GET : GET를 통해 해당 리소스를 조회합니다. 리소스를 조회하고 해당 도큐먼트에 대한 자세한 정보를 가져온다.
* PUT를 통해 해당 리소스를 수정합니다.
* DELETE DELETE를 통해 리소스를 삭제합니다.

## REST API의 개발원칙
### 자원을 식별할 수 있어야 한다.
  * URL (Uniform Resource Locator) 만으로 내가 어떤 자원을 제어하려고 하는지 알 수 있어야 한다. 자원을 제어하기 위해서, 자원의 위치는 물론 자원의 종류까지 알 수 있어야 한다는 의미이다.
  * Server가 제공하는 정보는 JSON 이나 XML 형태로 HTTP body에 포함되어 전송 시킨다.

## 개발과정
### 자바의 Persistence Framework는 Object와 DB테이블을 매핑하기위해 JPA : ORM(Object Relational Mapping) 기술을 활용하였다.

### DTO/VO
* CRUD의 대상이 될 Model을 담당하는 DTO/VO는 생성: Member class 

### CRUD
* 멤버의 정보를 다루는 Controller : MemberController
* @RestController : 전통적인 Spring MVC 컨트롤러 어노테이션의 @Controller는 주로 view(화면) 를 반환하기 위해 사용한다.
* 하지만 Spring MVC 컨트롤러를 사용할 대 Data를 반환해야 하는 경우도 있으며 그러기 위해 @Controller와 @ResponseBody가 합쳐진 어노테이션을 활용해 JSON형태로 반환해 주었다.

#### READ
* MemberController : getMembers(), getMemberById(@PathVariable("memberid") Long memberId)
* @PathVariable
  * 요청 URL을 파라미터로 사용(경로변수)
  * 요청 URL : /member/{memberid}
  * 파라메터로 처리: @PathVariable("memberid") Long memberId
  * 경로의 값을 변수로 사용하기 위해서 중괄호({}) 로 묶어주었다.

#### CREATE 유저생성하기 구현
* 멤버 회원가입 구현
* Object가 아닌 낱개의 형태로 받기 위해 @RequestParam 어노테이션을 사용하여 변수를 하나씩 받았다.
* TEST는 REST Client인 Postman 웹 확장 기능을사용하여 POST Method를 테스트해보았다.
  @PostMapping("")
  public Member signMember(@RequestParam(value = "memberid") Long memberId
          , @RequestParam(value = "membername") String memberName){
      Member member = new Member();
      member.setId(memberId);
      member.setName(memberName);
      return memberService.memberSignUp(member);
  }

#### UPDATE
* 멤버 정보 수정하기를 구현
@PutMapping("/{memberid}")
public Member modifyMember(
        @PathVariable("memberid") Long memberId,
        @RequestParam("membername") String memberName
){
    Member member = memberService.memberInfo(memberId);
    member.setName(memberName);
    return memberService.memberModify(member);
}

#### DELETE
* 멤버 정보 삭제하기를 구현
@DeleteMapping("/{memberid}")
public void resignMember(@PathVariable Long memberid){
    memberService.memberResign(memberid);
}

## 정리
* 스프링을 이용한 웹 서비스 개발은 Layered Architecture를 활용하여 개발하고, 데이터는 모델클래스를 작성하여 처리한다.
* HTTP의 GET, POST, PUT, DELETE를 주로 활용하여 데이터의 CRUD를 구현한다.
* 웹 서비스 테스트를 REST 클라이언트 툴을 통해 가능하다(Postman)
* 스프링 REST 애플리케이션은 Layered Architecture로 작성되고 @Controller가 최초로 응답을 받고 @Service를 통해 기능을 수행한다.
* 각 레이어는 각각의 역할을 가지며 Controller 단은 클라이언트의 요청을 분석해서 Service단으로 넘겨주는 역할을 수행한다.
