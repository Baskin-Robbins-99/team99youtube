![header](https://capsule-render.vercel.app/api?type=wave&height=250&color=FD9F28&text=Baskin-Robbins99&animation=twinkling&fontColor=FFD900&fontAlignY=30&stroke=FFFFFF&strokeWidth=3)


# 👍프로젝트 소개♡ ٩(´▽`)۶ ♡      
## 배스킨라빈스 99 (Baskin-Robbins 99) 
- 배스킨 라빈스의 다양한 아이스크림을 고르듯  개인의 취향에 맞는 영상들을 검색,보관하고 현재 가장 인기있는<br/>
  영상들을 추천해주는 동영상 플랫폼 앱 입니다.

  
# 💖역할 분담  
|이름|역할|
|------|---|
|이성진|비디오 검색(SearchFragment) |
|황일규|상세 정보 (VideoDetailFragment)  |
|남윤희|홈 화면 (HomeFragment) & 추가 구현 기능  |
|권용일|홈 화면 (HomeFragment) & 추가 구현 기능  |
|박혜린|마이 페이지 (MyVideoFragment) |


# 😝주요 기능
<details>
  <summary>HomeFragment</summary>
  - API활용하여서 Trend 비디오 목록 구현<br/>
  - videoCategories 엔드 포인트를 사용하여 원하는 목록 조회(특정카테고리)<br/>
  - 가져온 채널 및 비디오 표시(대표이미지, 제목)<br/>
  - 선택된 비디오를 VideoDetailFragment 데이터 넘겨주기<br/>
   <div markdown="1">
</details>
<details>
  <summary>SearchFragment</summary>
  - API활용하여서 검색된 비디오 정보 가져오기<br/>
  - 추천 목록을 제공하여서 해당 키워드의 영상 보여주기<br/>
   <div markdown="1">
</details>
<details>
  <summary>VideoDetailActivicty</summary>
  - '북마크' 버튼을 누르면 선택된 비디오를 내부데이터로 저장하기.<br/>
  - '북마크' 버튼을 두 번 클릭 시 좋아요 기능 없어지기<br/>
  - '북마크' 누른 비디오를 MyVideoFragment로 데이터 넘겨주기<br/>
  - 시작과 종료 시 특별한 Effect넣기<br/>
   <div markdown="1">
</details>

<details>
  <summary>MyVideoFragment</summary>
  - 좋아요’ 누른 비디오 목록 보여주기(RecyclerView)사용<br/>
  - ‘썸네일' 클릭 시 '북마크'된 정보 내부데이터에서 없애기<br/>
  - 사용자의 프로필 사진, 이름등 개인정보 표시<br/>
   <div markdown="1">
</details>


# 🎞️와이어 프레임 및 ServiceUI
![image](https://github.com/Baskin-Robbins-99/team99youtube/assets/121241416/25e677fe-51ef-4032-82bb-0d1d4f7367c3)
![image](https://github.com/Baskin-Robbins-99/team99youtube/assets/121241416/72593c00-f827-4c64-bec3-a779e8a5ccc9)



# 🛠️사용기술
<img src="https://img.shields.io/badge/Kotlin-7F52FF?style=flat&logo=Kotlin&logoColor=white"/>
<img src="https://img.shields.io/badge/android-3DDC84?style=flat&logo=android&logoColor=white"/>
<img src="https://img.shields.io/badge/androidstudio-3DDC84?style=flat&logo=androidstudio&logoColor=white"/>
<img src="https://img.shields.io/badge/github-181717?style=flat&logo=github&logoColor=white"/>
