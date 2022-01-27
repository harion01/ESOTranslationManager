# ESOTranslationManager
ESO translating data manger

## User scenario
### 1. lang 파일 생성 
- 한글 패치에 사용 할 lang 파일 생성을 위해 TranslationManager 사용
1) 유저가 Translation manager를 실행
2) Translation manager 메뉴에서 "lang파일 생성"을 선택
3) 유저가 설정한 폴더에 kr.lang , tr.lang 파일이 생성 됨
  
  
### 2. 번역 카테고리 생성
- eso csv파일의 category를 기준으로 1개의 csv파일을 여러개로 분리한다. 분리된 각각의 csv파일은 weblate와 연동하여 하나의 번역 카테고리로 활용 됨
1) User가 UESP혹은 csv파일을 직접 참고해서, category가 어느 분류에 속하는지 categoryIndex 파일을 작성한다.
2) 유저가 Translation manager를 실행
3) Translation manager 메뉴에서 "번역 카테고리 생성"을 선택
4) 유저가 설정한 로컬 폴더에 csv파일이 카테고리로 분류되서 생성 됨
  
  
### 3. 번역용 csv 파일 업로드
- ESO 패치로 인해 client의 정보가 바뀔 때, 번역 서버와 연동 된 git csv파일을 업데이트 하기 위해 사용
1) 유저가 Translation manager를 실행
2) Translation manager 메뉴에서 "lang파일 업로드" 선택
3) git repository에 "2.번역 카테고리 생성" 기능으로 생성 된 로컬 폴더의 csv파일이 업로드 됨
  
  
  
## Data flow (v1.0)
### 1. lang 파일 생성
0) 유저가 Translation manger실행
1) Translation manger실행 시 최초 menu 화면 출력 
2) 유저가 "lang파일 생성"을 선택
3) config파일에 입력한 Git repository에서 csv파일을 config파일에 설정 된 폴더로 다운로드
4) 다운로드 된 csv파일들을 하나의 파일로 합침
5) 합쳐진 csv파일의 언어를 한국어에서 중국어로 변경
6) 중국어로 변경된 csv파일을 이용해서 kr.csv 생성
7) 중국어로 변경된 csv파일의 각 번역문 앞에 식별 번호를 추가해서 tr.csv 생성
8) 생성된 csv파일을 유저가 esoExtractData 툴을 이용해서 lang파일로 변환

### 2. 번역 카테고리 생성
0) 유저가 Translation manger실행
1) 유저가 UESP홈페이지를 참고해서 CategoryConfig.txt파일을 작성
2) 유저가 esoExtractData 툴을 이용해서 eso client에서 lang파일을 추출 후 csv로 변환
3) 유저가 csv파일을 config에 입력한 csv경로에 위치 시킴
4) Translation manger실행 시 최초 menu 화면 출력 
5) 유저가 "번역 카테고리 생성"을 선택 
6) config 폴더에 포함된 CategoryConfig.txt 파일을 읽어서 카테고리 폴더 구조 생성
7) config 파일에 입력한 csv파일 경로에서 csv파일을 찾아서 메모리에 load
8) categoryConfig를 참조해서 csv파일을 각 폴더로 분리

### 3. 번역용 csv 파일 업로드
1) 유저가 git을 이용해서 repository에 csv파일을 업로드



