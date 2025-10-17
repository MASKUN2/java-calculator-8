# java-calculator-precourse

## 우아한테크코스(Woowa Tech Course) 웹 백엔드 8기 1주 차 프리코스 과제

요구사항 : [mission.md](docs/mission.md)

## 요구사항분석

#### 과제 진행 요구사항

이슈 없음

#### 기능 요구 사항

#### 프로그래밍 요구 사항

이슈 없음

## 기능 목록

| ID | 관계 ID | 카테고리  | 기능 이름 한글                      | 기능 이름 영어                                      | 설명                                          | 기존 요구사항 여부 |
|----|-------|-------|-------------------------------|-----------------------------------------------|---------------------------------------------|------------|
| 1  |       | 입력    | 문자열 입력                        | string input                                  |                                             | 예          |
| 2  |       | 처리    | 구분자를 이용한 문자열 분리               | split string by delimiters                    |                                             | 예          |
| 3  | 2     | 처리    | 기본 구분자 지원                     | support default delimiters                    | `,` 와 `:`                                   | 예          |
| 4  | 2     | 처리    | 커스텀 구분자 선언 지원                 | support custom delimiter declaration          | 문자열 앞부분의 `//`와 `\n` 사이에 선언                  | 예          |
| 5  |       | 처리    | 문자열 숫자 변환                     | string to numbers parsing                     |                                             | 예          |
| 6  | 5     | 처리    | 숫자 정수 지원                      | support integer number                        |                                             | 예          |
| 7  |       | 계산    | 숫자 덧셈                         | calculate sum of numbers                      |                                             | 예          |
| 8  |       | 출력    | 출력 포맷 설정                      | set up print format                           |                                             | 아니오        |
| 9  |       | 출력    | 결과를 출력하기                      | print result                                  | 계산 결과를 출력한다                                 | 예          |
| 10 | 1     | 오류    | 잘못된 입력에 의한 오류                 | error for wrong input                         | IllegalArgumentException을 발생시킨 후 애플리케이션은 종료 | 예          |
| 11 | 1     | 예외 복구 | null 또는 "" 입력을 0으로 처리         | handle `null` or empty input for "0"          |                                             | 예          |
| 12 | 4     | 오류    | 잘못된 커스텀 구분자 선언에 대한 오류         | error for wrong custom delimiter declaration  | 선언 불가능 함 = [`.`, `/n`, `숫자`]                | 아니오        |
| 13 | 4     | 예외 복구 | 커스텀 구분자가 기본 구분자와 겹치는 경우 무시 처리 | ignore custom delimiter equals to any default |                                             | 아니오        |
| 14 | 5     | 오류    | 양수가 아닌 숫자에 대한 오류              | error for negative numbers                    |                                             | 아니오        |
| 15 | 5     | 오류    | 숫자가 아닌 입력에 대한 오류              | error for non-numeric parts                   |                                             | 예          |