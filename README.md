# java-calculator-precourse

## 우아한테크코스(Woowa Tech Course) 웹 백엔드 8기 1주 차 프리코스 과제

**문자열 덧셈 계산기**  
요구사항 : [mission.md](docs/mission.md)

## 요구사항분석

#### 과제 진행 요구사항

이슈 없음

#### 기능 요구 사항

#### 프로그래밍 요구 사항

이슈 없음

## 기능 목록

| ID | 관계 ID | 카테고리  | 기능 이름 한글              | 기능 이름 영어                                     | 설명                                          | 기존 요구사항 여부 |
|----|-------|-------|-----------------------|----------------------------------------------|---------------------------------------------|------------|
| 18 |       | 통합    | 문자열 덧셈 계산기            | string sum calculator                        | application                                 | 아니오        |
| 1  |       | 입력    | 문자열 입력                | string input                                 |                                             | 예          |
| 2  |       | 처리    | 구분자를 이용한 문자열 분리       | split string by delimiters                   |                                             | 예          |
| 3  | 2     | 처리    | 기본 구분자 지원             | support default delimiters                   | `,` 와 `:`                                   | 예          |
| 4  | 2     | 처리    | 커스텀 구분자 선언 지원         | support custom delimiter declaration         | 문자열 앞부분의 `//`와 `\n` 사이에 선언                  | 예          |
| 5  |       | 처리    | 문자열 숫자 변환             | string to numbers parsing                    |                                             | 예          |
| 7  |       | 계산    | 정수 덧셈                 | sum integers                                 |                                             | 예          |
| 9  |       | 출력    | 결과를 출력하기              | print result                                 | 계산 결과를 출력한다                                 | 예          |
| 10 | 1     | 오류    | 잘못된 입력에 의한 오류         | error for wrong input                        | IllegalArgumentException을 발생시킨 후 애플리케이션은 종료 | 예          |
| 11 | 5     | 예외 복구 | "" 입력을 0으로 처리         | handle empty String input for "0"            |                                             | 예          |
| 12 | 4     | 오류    | 잘못된 커스텀 구분자 선언에 대한 오류 | error for wrong custom delimiter declaration | 선언 불가능 함 = [`.`, `/n`, `숫자`]                | 아니오        |
| 13 | 4     | 예외 복구 | 중복 구분자 무시 처리          | ignore duplicated delimiter                  |                                             | 아니오        |
| 14 | 5     | 오류    | 양수가 아닌 숫자에 대한 오류      | error for negative numbers                   |                                             | 예          |
| 15 | 5     | 오류    | 숫자가 아닌 입력에 대한 오류      | error for non-numeric parts                  |                                             | 예          |
| 16 | 5     | 오류    | 정수가 아닌 입력에 대한 오류      | error for non-integer parts                  |                                             | 아니오        |
| 17 |       | 출력    | 실행시 설명 출력             | show instruction                             | "덧셈할 문자열을 입력해 주세요." 출력                      | 아니오        |
| 18 | 2     | 처리    | 구분자 선언부와 숫자 선언부 분리    | isolate delimiter declaration                |                                             |            |

## 회고

소감문 : [reaction_paper.md](docs/reaction_paper.md)