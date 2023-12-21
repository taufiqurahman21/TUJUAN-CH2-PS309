package com.dicoding.capstoneproductfix.data.network.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\u0005J\u0011\u0010\u000b\u001a\u00020\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u000e\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u000fJ\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u000fJ\u000e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u000fJ\u0019\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015J\u0019\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0011H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0018J\u0019\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001b"}, d2 = {"Lcom/dicoding/capstoneproductfix/data/network/repository/LoginRepository;", "", "dataStore", "Landroidx/datastore/core/DataStore;", "Landroidx/datastore/preferences/core/Preferences;", "(Landroidx/datastore/core/DataStore;)V", "emailDS", "Landroidx/datastore/preferences/core/Preferences$Key;", "", "predictDS", "userIdKeyDS", "clearTokenFromDataStore", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getEmailFromDataStore", "Lkotlinx/coroutines/flow/Flow;", "getLoginResult", "Lcom/dicoding/capstoneproductfix/data/model/UserLogin;", "getPredictFromDataStore", "saveEmail", "email", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveLoginResult", "loginResult", "(Lcom/dicoding/capstoneproductfix/data/model/UserLogin;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "savePredict", "predict", "app_debug"})
public final class LoginRepository {
    @org.jetbrains.annotations.NotNull
    private final androidx.datastore.core.DataStore<androidx.datastore.preferences.core.Preferences> dataStore = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.datastore.preferences.core.Preferences.Key<java.lang.String> userIdKeyDS = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.datastore.preferences.core.Preferences.Key<java.lang.String> emailDS = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.datastore.preferences.core.Preferences.Key<java.lang.String> predictDS = null;
    
    public LoginRepository(@org.jetbrains.annotations.NotNull
    androidx.datastore.core.DataStore<androidx.datastore.preferences.core.Preferences> dataStore) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<com.dicoding.capstoneproductfix.data.model.UserLogin> getLoginResult() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.lang.String> getPredictFromDataStore() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object savePredict(@org.jetbrains.annotations.NotNull
    java.lang.String predict, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object saveLoginResult(@org.jetbrains.annotations.NotNull
    com.dicoding.capstoneproductfix.data.model.UserLogin loginResult, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object saveEmail(@org.jetbrains.annotations.NotNull
    java.lang.String email, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.lang.String> getEmailFromDataStore() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object clearTokenFromDataStore(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}