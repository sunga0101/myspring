package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class LottoService {
    // 모델이 관리하는 데이터. 컨트롤러가 제어할 수 없음. 조금 더 안정적.
    private int hits = 0;

    // hits 메소드
    public int addHit() { //누군가 방문했을 때 호출하는 메소드
        return ++hits;
    }

    // lotto 메소드
}
