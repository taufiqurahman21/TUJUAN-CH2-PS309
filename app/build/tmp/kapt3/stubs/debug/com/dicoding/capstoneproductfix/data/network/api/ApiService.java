package com.dicoding.capstoneproductfix.data.network.api;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005J\u001b\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u001b\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\b\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u001b\u0010\r\u001a\u00020\u000e2\b\b\u0001\u0010\b\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u001b\u0010\u000f\u001a\u00020\f2\b\b\u0001\u0010\b\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0010"}, d2 = {"Lcom/dicoding/capstoneproductfix/data/network/api/ApiService;", "", "getData", "Lretrofit2/Response;", "Lokhttp3/ResponseBody;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPredictedInterest", "Lcom/dicoding/capstoneproductfix/data/model/PredictedInterestResponse;", "requestBody", "Lcom/google/gson/JsonObject;", "(Lcom/google/gson/JsonObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "inputdata", "Lcom/dicoding/capstoneproductfix/data/model/ErrorMessageResponseRegister;", "login", "Lcom/dicoding/capstoneproductfix/data/model/ErrorMessageResponseLogin;", "register", "app_debug"})
public abstract interface ApiService {
    
    @retrofit2.http.POST(value = "register")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object register(@retrofit2.http.Body
    @org.jetbrains.annotations.NotNull
    com.google.gson.JsonObject requestBody, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.dicoding.capstoneproductfix.data.model.ErrorMessageResponseRegister> $completion);
    
    @retrofit2.http.POST(value = "login")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object login(@retrofit2.http.Body
    @org.jetbrains.annotations.NotNull
    com.google.gson.JsonObject requestBody, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.dicoding.capstoneproductfix.data.model.ErrorMessageResponseLogin> $completion);
    
    @retrofit2.http.POST(value = "input-data")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object inputdata(@retrofit2.http.Body
    @org.jetbrains.annotations.NotNull
    com.google.gson.JsonObject requestBody, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.dicoding.capstoneproductfix.data.model.ErrorMessageResponseRegister> $completion);
    
    @retrofit2.http.GET(value = "get-data")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getData(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<okhttp3.ResponseBody>> $completion);
    
    @retrofit2.http.POST(value = "predict")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getPredictedInterest(@retrofit2.http.Body
    @org.jetbrains.annotations.NotNull
    com.google.gson.JsonObject requestBody, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.dicoding.capstoneproductfix.data.model.PredictedInterestResponse> $completion);
}