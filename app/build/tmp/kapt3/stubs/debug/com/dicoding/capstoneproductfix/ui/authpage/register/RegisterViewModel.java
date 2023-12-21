package com.dicoding.capstoneproductfix.ui.authpage.register;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0010"}, d2 = {"Lcom/dicoding/capstoneproductfix/ui/authpage/register/RegisterViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "apiService", "Lcom/dicoding/capstoneproductfix/data/network/api/ApiService;", "resultRegister", "Landroidx/lifecycle/MutableLiveData;", "Lcom/dicoding/capstoneproductfix/data/network/Result;", "getResultRegister", "()Landroidx/lifecycle/MutableLiveData;", "getRegister", "", "requestBody", "Lcom/google/gson/JsonObject;", "app_debug"})
public final class RegisterViewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.dicoding.capstoneproductfix.data.network.api.ApiService apiService = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<com.dicoding.capstoneproductfix.data.network.Result> resultRegister = null;
    
    public RegisterViewModel(@org.jetbrains.annotations.NotNull
    android.app.Application application) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<com.dicoding.capstoneproductfix.data.network.Result> getResultRegister() {
        return null;
    }
    
    public final void getRegister(@org.jetbrains.annotations.NotNull
    com.google.gson.JsonObject requestBody) {
    }
}