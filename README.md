# ToyProject
안드로이드 스튜디오의 여러 UI/UX와 기능들을 연습해보고 나중에 보고 사용할 수 있도록 정리해서 올리는 저장소

### LiveData,DataBinding,viewModel을 이용했다.
기존의 LiveData와 ViewModel로 만든 간단한 카운트 앱에서 DataBinding을 이용해 앱을 구현했다. observer기능을 이용해 livedata를 관찰해 view를 변경한 것 과는 다르게 dataBinding을 이용하였다.
문제점: EditText에서 liveData로 값을 받을 때 livedata가 String형이 아니면 오류가 나는데 이를 xml상에서 형변환이 가능한지 찾아봐야 겠다.
추가적으로 다양한 리스너들을 xml상에서 달아주기 위해 custom을 해야하는 것이 과연 생산성이 좋을까? 라는 생각이 들었다.
