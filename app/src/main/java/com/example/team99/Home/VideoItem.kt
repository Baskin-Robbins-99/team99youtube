package com.example.team99.Home


import java.io.Serializable


data class VideoItem(
    val thumbnails: String,
    val title: String,
    val categoryId: String?,
    val chanelId: String,
    var description: String
    //var isLike: Boolean,
) : Serializable {
    companion object {
        val title: CharSequence?
            get() {
                return "GODS (ft. 뉴진스) (공식 뮤직 비디오) | 2023 월드 챔피언십 주제곡 - 리그 오브 레전드"
            }
        val description: CharSequence?
            get() {
                return "한 챔피언의 꺾이지 않는 의지와 굽히지 않는 마음에 관한 이야기입니다.\n" +
                    "\n" +
                    "2023 월드 챔피언십 공식 주제곡 및 뮤직 비디오(ft. 뉴진스)를 확인해 보세요.\n" +
                    "\n" +
                    "*지금 듣기  - https://found.ee/GODS2023\n" +
                    "스포티파이 - https://found.ee/GODS2023-Spotify\n" +
                    "아마존 뮤직 - https://found.ee/GODS2023-Amazon\n" +
                    "애플 뮤직 - https://found.ee/GODS2023-Apple\n" +
                    "유튜브 - https://found.ee/GODS2023-YouTube\n" +
                    "디저 - https://found.ee/GODS2023-Deezer\n" +
                    "\n" +
                    "10월 10일부터 11월 19일까지 #2023월드챔피언십 경기를 https://lolesports.com에서 시청해 보세요.\n" +
                    "\n" +
                    "■LIVE & LIVE VOD\n" +
                    "- 네이버: https://game.naver.com/esports\n" +
                    "- 아프리카TV: http://bj.afreecatv.com/aflol\n" +
                    "- 트위치: https://www.twitch.tv/lck_korea\n" +
                    "■ LCK 채널 구독 및 좋아요!\n" +
                    "- LoL e스포츠 홈페이지: https://lolesports.com/\n" +
                    "- LCK 공식 페이스북: https://www.facebook.com/officiallck\n" +
                    "- LCK 공식 인스타그램: https://www.instagram.com/lckofficial/\n" +
                    "- LCK 공식 틱톡 : https://tiktok.com/@lck_official\n" +
                    "- LCK 공식 트위터 (영문): https://twitter.com/lck_global\n" +
                    "\n" +
                    "#2023월드챔피언십 #리그오브레전드 #뉴진스 #NewJeans \n" +
                    "\n" +
                    "\n" +
                    "참여해 주신 분들\n" +
                    "'GODS'\n" +
                    "참여 아티스트: 뉴진스\n" +
                    "작사 및 작곡: Mako(알렉스 시버) 및 세바스티앙 나잔드\n" +
                    "프로듀싱: 세바스티앙 나잔드 및 Mako(알렉스 시버)\n" +
                    "추가 프로듀싱: 제이슨 데주지오\n" +
                    "*믹싱: 세르반 게니아\n" +
                    "*마스터링: Sterling Sound의 랜디 메릴  \n" +
                    "보컬: 뉴진스\n" +
                    "책임 프로듀서 라이엇 게임즈 뮤직\n" +
                    "저작권: 라이엇 게임즈 2023"

            }
    }
}

