package com.dicoding.capstoneproductfix.ui.authpage.login;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0019\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0014H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017J\u0019\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001aH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001bR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001c"}, d2 = {"Lcom/dicoding/capstoneproductfix/ui/authpage/login/LoginViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "pref", "Lcom/dicoding/capstoneproductfix/data/network/repository/LoginRepository;", "(Landroid/app/Application;Lcom/dicoding/capstoneproductfix/data/network/repository/LoginRepository;)V", "apiService", "Lcom/dicoding/capstoneproductfix/data/network/api/ApiService;", "resultLogin", "Landroidx/lifecycle/MutableLiveData;", "Lcom/dicoding/capstoneproductfix/data/network/Result;", "getResultLogin", "()Landroidx/lifecycle/MutableLiveData;", "getLogin", "", "requestBody", "Lcom/google/gson/JsonObject;", "initApiClientWithToken", "userID", "", "saveEmailToDataStore", "email", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveUserLoginToDataStore", "userLogin", "Lcom/dicoding/capstoneproductfix/data/model/UserLogin;", "(Lcom/dicoding/capstoneproductfix/data/model/UserLogin;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class LoginViewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.dicoding.capstoneproductfix.data.network.repository.LoginRepository pref = null;
    @org.jetbrains.annotations.NotNull
    private final com.dicoding.capstoneproductfix.data.network.api.ApiService apiService = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<com.dicoding.capstoneproductfix.data.network.Result> resultLogin = null;
    
    public LoginViewModel(@org.jetbrains.annotations.NotNull
    android.app.Application application, @org.jetbrains.annotations.NotNull
    com.dicoding.capstoneproductfix.data.network.repository.LoginRepository pref) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<com.dicoding.capstoneproductfix.data.network.Result> getResultLogin() {
        return null;
    }
    
    public final void getLogin(@org.jetbrains.annotations.NotNull
    com.google.gson.JsonObject requestBody) {
    }
    
    private final java.lang.Object saveUserLoginToDataStore(com.dicoding.capstoneproductfix.data.model.UserLogin userLogin, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final java.lang.Object saveEmailToDataStore(java.lang.String email, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final void initApiClientWithToken(java.lang.String userID) {
    }
}