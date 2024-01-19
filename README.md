# REST API 프로젝트

## 👨‍🏫REST API란
출처: https://velog.io/@somday/RESTful-API-%EC%9D%B4%EB%9E%80
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

  ## 개발과정
  
  ### 자바의 Persistence Framework는 Object와 DB테이블을 매핑하기위해 JPA : ORM(Object Relational Mapping) 기술을 활용하였다.

  ### DTO/VO
  * CRUD의 대상이 될 Model을 담당하는 DTO/VO는 생성: Member
