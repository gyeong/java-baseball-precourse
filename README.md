# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 도메인 리스트
* Game 게임
* GamePlayer 게임플레이어
* GamePresenter 게임진행자

## 게임 시나리오
1. 게임 시작 여부 확인
    1. 게임 올스트라이크 여부 확인
        1. 게임 랜덤 숫자 생성
        2. 게임 플레이어 숫자 입력
        4. 게임 랜덤 숫자와 게임 플레이어 숫자 비교
            1. 스트라이크 카운팅
            2. 볼 카운팅
        5. 게임 결과 출력
    2. 게임 재시작/종료 여부 확인
        1. 게임 플레이어 재시작/종료 여부 입력

## 기능 정리
* 게임 랜덤 숫자 생성 기능 (Game)
* 사용자 숫자 입력 안내 출력 기능 (GamePresenter)
* 사용자 숫자 입력 기능 (GamePlayer)
* 게임 종료 여부 안내 출력 기능 (GamePresenter)
* 사용자 게임 종료 여부 입력 기능  (GamePlayer)
* 입력 된 데이터 validation 체크 기능 (GamePresenter)
* 스트라이크 카운팅 기능 (Game)
* 볼 카운팅 기능 (Game)
* 게임 결과 출력 기능 (GamePresenter)
* 게임 상태 체크 기능 (Game)
