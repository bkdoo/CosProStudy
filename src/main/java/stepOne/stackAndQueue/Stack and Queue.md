# Stack and Queue
### 20220816 - 같은 숫자는 싫어 (Solution1.java)
1차원 int 배열이 주어지고 연속된 숫자를 제거한 배열을 리턴하는 문제이다.
1. input 배열의 첫 값은 큐와 스택애 모두 넣는다.
2. 다음 값 부터 스택의 맨 위 값(peek)과 비교하여 다르면, 큐와 스택에 해당 값을 넣는다.
3. 최종 완성된 큐를 1차원 int 배열로 변환한다.
3)의 과정에서 stream을 활용하고자 하였으나, 아직 짬이 부족한듯 하다. stream을 다시 복습하여 쉽게 쉽게 작성할 수 있어야 겠다.