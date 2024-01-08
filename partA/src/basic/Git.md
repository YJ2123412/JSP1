#GIT


###GIt 설치

    
* [다운로드](https://git-sum.com/)

### github 원격 저장소 사용하기
   
* [사이트](https://githuab.com/)

### 로컬 저장소 초기화
 *git 명령어 실행하기

  ![Alt text](<../../img/스크린샷 2023-12-29 161149.png>)
  
  
  p\Coding\Main 폴더 아래 git -> 초기화


    $ git init
    

    *git 사용자 이메일r과 네임 설정
        $git config --global user.email "자신의 이메일"
        $git config --global user.name "자신의 이름"

    *사용자 이메일 확인
            $git config user.email




###원격저장소 등록 

    *원격 저장소 만들기
      $git remote add origin (github의 저장소 주소)
    
    *원격 저장소 확인
      &git remote -v



###commit
   
   *커밋은 파일의 변경점을 관리하기 위한 기록입니다. 

  *우리는 편의상 git 명령어 대신 vscode 메뉴를 활용하겠습니다.

   *커밋 등 버전관리가 필요없는 bin 폴더 또는 vs code 설정 파일은 제외시키는 '.gitignore'파일을 추가합니다.

    -세개의 원이 있는 아이콘 메뉴를 클릭하면 commit 대상이 되는 파일들이 changes 항목 아래에 보입니다.
    -해당 파일들 중 커밋을 원하는 파일들을 선택, + 아이콘을 클릭
    -위에서 선택한 파일들은 커밋 대상이 되고 Stage changes 항목 아래에 보입니다
    -맨 위 입력란에 커밋메시지를 작성하고 comit버튼을 클릭합니다.
    -커밋기록을확인하는 명령어:  $git log



###push

    *커밋된 파일들을 원격저장소로 보내 저장합니다. 
      $git push origin main
 
     -로컬저장소 main의 커밋된 파일을 원격저장소 origin으로 push하는 명령 
     -push를 처음할 때는 github의 인증 과정을 위해 브라우저에 인증절차 화면이 자동으로 뜹니다. 버튼 클릭~~

    * 저장소를 새로 고침하면 커밋한 파일들의 목록을 볼 수 있습니다.




[참고] 로컬저장소는 git폴더 삭제하고 원격저장소는 리포지토리만 삭제하면 완전 처음부터 다시 할 수 있습니다.