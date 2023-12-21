package com.dicoding.capstoneproductfix.ui.questionpage;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bJ\u0019\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u000eH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001eJ\u000e\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u001d\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00150\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006 "}, d2 = {"Lcom/dicoding/capstoneproductfix/ui/questionpage/QuestionViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "pref", "Lcom/dicoding/capstoneproductfix/data/network/repository/LoginRepository;", "(Landroid/app/Application;Lcom/dicoding/capstoneproductfix/data/network/repository/LoginRepository;)V", "apiService", "Lcom/dicoding/capstoneproductfix/data/network/api/ApiService;", "apiServiceHistory", "resultHistory", "Landroidx/lifecycle/MutableLiveData;", "Lcom/dicoding/capstoneproductfix/data/network/Result;", "resultHistory2", "", "getResultHistory2", "()Landroidx/lifecycle/MutableLiveData;", "resultQuestion", "getResultQuestion", "selectedOptionsMap", "", "", "getSelectedOptionsMap", "()Ljava/util/Map;", "getAnswer", "", "requestBody", "Lcom/google/gson/JsonObject;", "savePredictToDataStore", "predict", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setHistory", "app_debug"})
public final class QuestionViewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.dicoding.capstoneproductfix.data.network.repository.LoginRepository pref = null;
    @org.jetbrains.annotations.NotNull
    private final com.dicoding.capstoneproductfix.data.network.api.ApiService apiService = null;
    @org.jetbrains.annotations.NotNull
    private final com.dicoding.capstoneproductfix.data.network.api.ApiService apiServiceHistory = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<com.dicoding.capstoneproductfix.data.network.Result> resultQuestion = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<com.dicoding.capstoneproductfix.data.network.Result> resultHistory = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.String> resultHistory2 = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.Map<java.lang.String, java.lang.Integer> selectedOptionsMap = null;
    
    public QuestionViewModel(@org.jetbrains.annotations.NotNull
    android.app.Application application, @org.jetbrains.annotations.NotNull
    com.dicoding.capstoneproductfix.data.network.repository.LoginRepository pref) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<com.dicoding.capstoneproductfix.data.network.Result> getResultQuestion() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.lang.String> getResultHistory2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Map<java.lang.String, java.lang.Integer> getSelectedOptionsMap() {
        return null;
    }
    
    public final void getAnswer(@org.jetbrains.annotations.NotNull
    com.google.gson.JsonObject requestBody) {
    }
    
    private final java.lang.Object savePredictToDataStore(java.lang.String predict, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    public final void setHistory(@org.jetbrains.annotations.NotNull
    com.google.gson.JsonObject requestBody) {
    }
}