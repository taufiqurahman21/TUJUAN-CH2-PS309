package com.dicoding.capstoneproductfix.ui.profilepage;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\f\u001a\u00020\rR\u0019\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/dicoding/capstoneproductfix/ui/profilepage/ProfileViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "pref", "Lcom/dicoding/capstoneproductfix/data/network/repository/LoginRepository;", "(Landroid/app/Application;Lcom/dicoding/capstoneproductfix/data/network/repository/LoginRepository;)V", "email", "Landroidx/lifecycle/LiveData;", "", "getEmail", "()Landroidx/lifecycle/LiveData;", "clearUserData", "", "app_debug"})
public final class ProfileViewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.dicoding.capstoneproductfix.data.network.repository.LoginRepository pref = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<java.lang.String> email = null;
    
    public ProfileViewModel(@org.jetbrains.annotations.NotNull
    android.app.Application application, @org.jetbrains.annotations.NotNull
    com.dicoding.capstoneproductfix.data.network.repository.LoginRepository pref) {
        super(null);
    }
    
    public final void clearUserData() {
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.lang.String> getEmail() {
        return null;
    }
}