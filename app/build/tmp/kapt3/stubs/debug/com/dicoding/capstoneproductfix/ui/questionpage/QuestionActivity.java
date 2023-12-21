package com.dicoding.capstoneproductfix.ui.questionpage;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\u0014H\u0002J\u0012\u0010\u0015\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014J\b\u0010\u0018\u001a\u00020\u0014H\u0014J\b\u0010\u0019\u001a\u00020\u0014H\u0002J\u0010\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001cH\u0003J\b\u0010\u001d\u001a\u00020\u0014H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lcom/dicoding/capstoneproductfix/ui/questionpage/QuestionActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "adapter", "Lcom/dicoding/capstoneproductfix/ui/questionpage/AdapterQuestion;", "getAdapter", "()Lcom/dicoding/capstoneproductfix/ui/questionpage/AdapterQuestion;", "adapter$delegate", "Lkotlin/Lazy;", "binding", "Lcom/dicoding/capstoneproductfix/databinding/ActivityQuestionBinding;", "currentPosition", "", "currentPosition2", "loginSave", "Lcom/dicoding/capstoneproductfix/data/network/repository/LoginRepository;", "viewModel", "Lcom/dicoding/capstoneproductfix/ui/questionpage/QuestionViewModel;", "viewModelFactory", "Lcom/dicoding/capstoneproductfix/ui/viewmodelfactory/ViewModelFactoryLogin;", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "pageShow", "showDialogAlterQuestionNext", "context", "Landroid/content/Context;", "userQuestion", "app_debug"})
public final class QuestionActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.dicoding.capstoneproductfix.databinding.ActivityQuestionBinding binding;
    private com.dicoding.capstoneproductfix.ui.questionpage.QuestionViewModel viewModel;
    private com.dicoding.capstoneproductfix.ui.viewmodelfactory.ViewModelFactoryLogin viewModelFactory;
    private com.dicoding.capstoneproductfix.data.network.repository.LoginRepository loginSave;
    private int currentPosition = 0;
    private int currentPosition2 = 1;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy adapter$delegate = null;
    
    public QuestionActivity() {
        super();
    }
    
    private final com.dicoding.capstoneproductfix.ui.questionpage.AdapterQuestion getAdapter() {
        return null;
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void binding() {
    }
    
    private final void pageShow() {
    }
    
    private final void userQuestion() {
    }
    
    @android.annotation.SuppressLint(value = {"NotifyDataSetChanged"})
    private final void showDialogAlterQuestionNext(android.content.Context context) {
    }
    
    @java.lang.Override
    protected void onResume() {
    }
}