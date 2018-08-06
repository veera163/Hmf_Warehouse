package hmf.com.project.hmfwarehouse.activity;


import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import hmf.com.project.hmfwarehouse.Api.ResetPasswordApi;
import hmf.com.project.hmfwarehouse.AppController;
import hmf.com.project.hmfwarehouse.ESurvey;
import hmf.com.project.hmfwarehouse.R;
import hmf.com.project.hmfwarehouse.domains.SimpleRes;
import hmf.com.project.hmfwarehouse.utility.CustomAlertDialog;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;


public class OnBoardActivity extends AppCompatActivity {

    Toolbar toolbar;
    AlertDialog.Builder alertDialogBuilder;
    AlertDialog alertDialog;
    Bundle bundle;
    String url,oldpass,newpass,confpass;
    EditText edt_oldpwd,edt_new_password,edt_cnf_password;
    TextView veera;
    Button btnsubmit,btnReset;
    ImageView imgoldvissable,imgoldnotvissable,imgnewvissable,imgnewnotvissable,imgconfvissable,imgconfnotvissable;
    OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        veera=(TextView)findViewById(R.id.veera);
        veera.setText("board");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.

        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        // Handle presses on the action bar items
        switch (item.getItemId()) {

            case R.id.change_password:

                showInputDialog();
                break;

            case R.id.exit:
                bundle = new Bundle();
                bundle.putString(CustomAlertDialog.MESSAGE, "would you Like to close this App");
                alertDialogBuilder = new AlertDialog.Builder(this);
                alertDialogBuilder.setTitle("Exit Application?");
                alertDialogBuilder
                        .setMessage("would you Like to close this App!")
                        .setCancelable(false)
                        .setPositiveButton("Yes",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {

                                        Intent homeIntent = new Intent(Intent.ACTION_MAIN);
                                        homeIntent.addCategory( Intent.CATEGORY_HOME );
                                        homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                        startActivity(homeIntent);


                                    }
                                })

                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                dialog.cancel();
                            }
                        });

                alertDialog = alertDialogBuilder.create();
                alertDialog.show();
                break;
            case R.id.signout:

                bundle = new Bundle();
                bundle.putString(CustomAlertDialog.MESSAGE, "would you Like to Signout this App");
                alertDialogBuilder = new AlertDialog.Builder(this);
                alertDialogBuilder.setTitle("Signout Application?");
                alertDialogBuilder
                        .setMessage("would you Like to Signout this App!")
                        .setCancelable(false)
                        .setPositiveButton("Yes",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {

                                        ESurvey.clearCache();
                                        Intent intent = new Intent(OnBoardActivity.this, LoginActivity.class);
                                        startActivity(intent);
                                    }
                                })

                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                dialog.cancel();
                            }
                        });

                alertDialog = alertDialogBuilder.create();
                alertDialog.show();

            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

    private void showInputDialog() {


        LayoutInflater layoutInflater = LayoutInflater.from(OnBoardActivity.this);
        View promptView = layoutInflater.inflate(R.layout.changepwd, null);
        alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setView(promptView);
        alertDialog.show();

        edt_oldpwd=(EditText)promptView.findViewById(R.id.edt_oldpwd);
        edt_new_password=(EditText)promptView.findViewById(R.id.edt_new_password);
        edt_cnf_password=(EditText)promptView.findViewById(R.id.edt_cnf_password);
        btnsubmit=(Button)promptView.findViewById(R.id.btnsubmit);
        btnReset=(Button)promptView.findViewById(R.id.btnReset);

        imgoldvissable=(ImageView)promptView.findViewById(R.id.imgoldvissable);
        imgoldnotvissable=(ImageView)promptView.findViewById(R.id.imgoldnotvissable);

        imgnewvissable=(ImageView)promptView.findViewById(R.id.imgnewvissable);
        imgnewnotvissable=(ImageView)promptView.findViewById(R.id.imgnewnotvissable);

        imgconfvissable=(ImageView)promptView.findViewById(R.id.imgconfvissable);
        imgconfnotvissable=(ImageView)promptView.findViewById(R.id.imgconfnotvissable);

        imgoldvissable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgoldnotvissable.setVisibility(View.VISIBLE);
                imgoldvissable.setVisibility(View.GONE);
                edt_oldpwd.setTransformationMethod(PasswordTransformationMethod.getInstance());

            }
        });
        imgoldnotvissable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgoldnotvissable.setVisibility(View.GONE);
                imgoldvissable.setVisibility(View.VISIBLE);
                edt_oldpwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());

            }
        });


        imgnewvissable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgnewnotvissable.setVisibility(View.VISIBLE);
                imgnewvissable.setVisibility(View.GONE);
                edt_new_password.setTransformationMethod(PasswordTransformationMethod.getInstance());

            }
        });
        imgnewnotvissable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgnewnotvissable.setVisibility(View.GONE);
                imgnewvissable.setVisibility(View.VISIBLE);
                edt_new_password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());

            }
        });

        imgconfvissable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgconfnotvissable.setVisibility(View.VISIBLE);
                imgconfvissable.setVisibility(View.GONE);
                edt_cnf_password.setTransformationMethod(PasswordTransformationMethod.getInstance());

            }
        });
        imgconfnotvissable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgconfnotvissable.setVisibility(View.GONE);
                imgconfvissable.setVisibility(View.VISIBLE);
                edt_cnf_password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());

            }
        });

        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                oldpass=edt_oldpwd.getText().toString();
                newpass=edt_new_password.getText().toString();
                confpass=edt_cnf_password.getText().toString();
                boolean isValid = true;
                View focusView = null;
                edt_oldpwd.setError(null);
                if(TextUtils.isEmpty(oldpass)){
                    edt_oldpwd.setError(getString(R.string.error_field_required));
                    focusView = edt_oldpwd;
                    isValid = false;
                }
                else if(TextUtils.isEmpty(newpass)){
                    edt_new_password.setError(getString(R.string.error_field_required));
                    focusView = edt_new_password;
                    isValid = false;
                }
                else if(TextUtils.isEmpty(confpass)){
                    edt_cnf_password.setError(getString(R.string.error_field_required));
                    focusView = edt_cnf_password;
                    isValid = false;
                }
                else if(!newpass.equals(confpass)){

                    edt_cnf_password.setError("Password is not matched");
                    focusView = edt_cnf_password;
                    isValid = false;
                }
                if (isValid){

                    resect(ESurvey.getLoginId(),oldpass,newpass);
                }
                else {
                    // There was an error; don't attempt login and focus the first
                    // form field with an error.
                    focusView.requestFocus();
                }



            }
        });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edt_oldpwd.setText("");
                edt_new_password.setText("");
                edt_cnf_password.setText("");
            }
        });


    }

    private void resect(String loginId, String oldpass, String newpass) {

        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Interceptor.Chain chain) throws IOException {
                Request original = chain.request();
                Request request = original.newBuilder()
                        .header("content-type", "application/json")
                        .method(original.method(), original.body())
                        .build();
                return chain.proceed(request);
            }
        });
        OkHttpClient client = httpClient.build();
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();
        progressDialog = ProgressDialog.show(OnBoardActivity.this, "Please wait.",
                "Being sent..!", true);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AppController.BaseUrl)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();
        ResetPasswordApi passwordApi = retrofit.create(ResetPasswordApi.class);

        JSONObject main=new JSONObject();
        try {
            main.put("oldPassword",oldpass);
            main.put("newPassword",newpass);
            main.put("userName",loginId);
            Call<SimpleRes> listCall=passwordApi.getUser(main.toString());
            listCall.enqueue(new Callback<SimpleRes>() {
                @Override
                public void onResponse(Call<SimpleRes> call, retrofit2.Response<SimpleRes> response) {

                    progressDialog.dismiss();

                    if(response.isSuccessful()){
                        alertDialog.dismiss();

                        SimpleRes simpleRes=response.body();
                        if(simpleRes.getMessageType().equals("success")){

                            Toast.makeText(OnBoardActivity.this, simpleRes.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                        else {

                            Toast.makeText(OnBoardActivity.this, simpleRes.getMessage(), Toast.LENGTH_SHORT).show();

                        }


                    }
                    else {

                        alertDialog.dismiss();

                        Toast.makeText(OnBoardActivity.this, response.message(), Toast.LENGTH_SHORT).show();

                    }

                }

                @Override
                public void onFailure(Call<SimpleRes> call, Throwable t) {

                    progressDialog.dismiss();

                    Toast.makeText(OnBoardActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onBackPressed() {

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Exit Application?");
        alertDialogBuilder
                .setMessage("would you Like to close this App !")
                .setCancelable(false)
                .setPositiveButton("Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent homeIntent = new Intent(Intent.ACTION_MAIN);
                                homeIntent.addCategory( Intent.CATEGORY_HOME );
                                homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(homeIntent);
                            }
                        })

                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        dialog.cancel();
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

    }

}
