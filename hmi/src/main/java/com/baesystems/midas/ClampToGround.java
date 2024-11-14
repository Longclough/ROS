package com.baesystems.midas;

import java.util.ArrayList;
import java.util.List;

import com.baesystems.midas.symbols.ISymbol;

public class ClampToGround {
    private static ClampToGround instance;

    public static ClampToGround getInstance() {
        if (instance == null) {
            instance = new ClampToGround();
        }
        return instance;
    }

    private boolean clampToGround = true;
    private List<ISymbol> symbols = new ArrayList<>();

    public void register(ISymbol symbol) {
        this.symbols.add(symbol);
        symbol.setClampToGround(clampToGround);
    }

    void setClampToGround(boolean clampToGround) {
        this.clampToGround = clampToGround;
        for (ISymbol symbol : symbols) {
            symbol.setClampToGround(clampToGround);
        }
    }

    public boolean isClampToGround() {
        return this.clampToGround;
    }
}