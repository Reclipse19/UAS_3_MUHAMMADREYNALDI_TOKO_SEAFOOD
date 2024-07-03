package com.example.lastchance.order;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;

import com.example.lastchance.R;
import com.example.lastchance.utils.FunctionHelper;
import com.google.android.material.button.MaterialButton;

public class OrderActivity2 extends AppCompatActivity {

    public static final String DATA_TITLE = "TITLE";
    String strTitle;
    int paket1 = 100000, paket2 = 40000, paket3 = 50000, paket4 = 60000, paket5 = 20000, paket6 = 35000,
            paket7 = 100000, paket8 = 40000, paket9 = 70000, paket10 = 35000, paket11 = 50000, paket12 = 30000;
    int itemCount1 = 0, itemCount2 = 0, itemCount3 = 0, itemCount4 = 0, itemCount5 = 0, itemCount6 = 0,
            itemCount7 = 0, itemCount8 = 0, itemCount9 = 0, itemCount10 = 0, itemCount11 = 0, itemCount12 = 0;
    int countP1, countP2, countP3, countP4, countP5, countP6,
            countP7, countP8, countP9, countP10, countP11, countP12, totalItems, totalPrice;
    ImageView imageAdd1, imageAdd2, imageAdd3, imageAdd4, imageAdd5, imageAdd6,
            imageAdd7, imageAdd8, imageAdd9, imageAdd10, imageAdd11, imageAdd12,
            imageMinus1, imageMinus2, imageMinus3, imageMinus4, imageMinus5, imageMinus6,
            imageMinus7, imageMinus8, imageMinus9, imageMinus10, imageMinus11, imageMinus12;
    Toolbar toolbar;
    TextView tvPaket1, tvPaket2, tvPaket3, tvPaket4, tvPaket5, tvPaket6,
            tvPaket7, tvPaket8, tvPaket9, tvPaket10, tvPaket11, tvPaket12,
            tvJumlahPorsi, tvTotalPrice;
    MaterialButton btnCheckout;
    OrderViewModel orderViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order2);

        setStatusbar();
        setInitLayout();
        setPaket1();
        setPaket2();
        setPaket3();
        setPaket4();
        setPaket5();
        setPaket6();
        setPaket7();
        setPaket8();
        setPaket9();
        setPaket10();
        setPaket11();
        setPaket12();
        setInputData();
    }

    private void setInitLayout() {
        toolbar = findViewById(R.id.toolbar);
        tvPaket1 = findViewById(R.id.tvPaket1);
        tvPaket2 = findViewById(R.id.tvPaket2);
        tvPaket3 = findViewById(R.id.tvPaket3);
        tvPaket4 = findViewById(R.id.tvPaket4);
        tvPaket5 = findViewById(R.id.tvPaket5);
        tvPaket6 = findViewById(R.id.tvPaket6);
        tvPaket7 = findViewById(R.id.tvPaket7);
        tvPaket8 = findViewById(R.id.tvPaket8);
        tvPaket9 = findViewById(R.id.tvPaket9);
        tvPaket10 = findViewById(R.id.tvPaket10);
        tvPaket11 = findViewById(R.id.tvPaket11);
        tvPaket12 = findViewById(R.id.tvPaket12);
        tvJumlahPorsi = findViewById(R.id.tvJumlahPorsi);
        tvTotalPrice = findViewById(R.id.tvTotalPrice);
        imageAdd1 = findViewById(R.id.imageAdd1);
        imageAdd2 = findViewById(R.id.imageAdd2);
        imageAdd3 = findViewById(R.id.imageAdd3);
        imageAdd4 = findViewById(R.id.imageAdd4);
        imageAdd5 = findViewById(R.id.imageAdd5);
        imageAdd6 = findViewById(R.id.imageAdd6);
        imageAdd7 = findViewById(R.id.imageAdd7);
        imageAdd8 = findViewById(R.id.imageAdd8);
        imageAdd9 = findViewById(R.id.imageAdd9);
        imageAdd10 = findViewById(R.id.imageAdd10);
        imageAdd11 = findViewById(R.id.imageAdd11);
        imageAdd12 = findViewById(R.id.imageAdd12);
        imageMinus1 = findViewById(R.id.imageMinus1);
        imageMinus2 = findViewById(R.id.imageMinus2);
        imageMinus3 = findViewById(R.id.imageMinus3);
        imageMinus4 = findViewById(R.id.imageMinus4);
        imageMinus5 = findViewById(R.id.imageMinus5);
        imageMinus6 = findViewById(R.id.imageMinus6);
        imageMinus7 = findViewById(R.id.imageMinus7);
        imageMinus8 = findViewById(R.id.imageMinus8);
        imageMinus9 = findViewById(R.id.imageMinus9);
        imageMinus10 = findViewById(R.id.imageMinus10);
        imageMinus11 = findViewById(R.id.imageMinus11);
        imageMinus12 = findViewById(R.id.imageMinus12);
        btnCheckout = findViewById(R.id.btnCheckout);

        strTitle = getIntent().getExtras().getString(DATA_TITLE);
        if (strTitle != null) {

            setSupportActionBar(toolbar);
            assert getSupportActionBar() != null;
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(strTitle);
        }

        orderViewModel = new ViewModelProvider(this).get(OrderViewModel.class);
    }

    private void setPaket1() {
        imageAdd1.setOnClickListener(v -> {
            itemCount1 = itemCount1 + 1;
            tvPaket1.setText(String.valueOf(itemCount1));
            countP1 = paket1 * itemCount1;
            setTotalPrice();
        });

        imageMinus1.setOnClickListener(v -> {
            if (itemCount1 > 0) {
                itemCount1 = itemCount1 - 1;
                tvPaket1.setText(String.valueOf(itemCount1));
            }
            countP1 = paket1 * itemCount1;
            setTotalPrice();
        });
    }

    private void setPaket2() {
        imageAdd2.setOnClickListener(v -> {
            itemCount2 = itemCount2 + 1;
            tvPaket2.setText(String.valueOf(itemCount2));
            countP2 = paket2 * itemCount2;
            setTotalPrice();
        });

        imageMinus2.setOnClickListener(v -> {
            if (itemCount2 > 0) {
                itemCount2 = itemCount2 - 1;
                tvPaket2.setText(String.valueOf(itemCount2));
            }
            countP2 = paket2 * itemCount2;
            setTotalPrice();
        });
    }

    private void setPaket3() {
        imageAdd3.setOnClickListener(v -> {
            itemCount3 = itemCount3 + 1;
            tvPaket3.setText(String.valueOf(itemCount3));
            countP3 = paket3 * itemCount3;
            setTotalPrice();
        });

        imageMinus3.setOnClickListener(v -> {
            if (itemCount3 > 0) {
                itemCount3 = itemCount3 - 1;
                tvPaket3.setText(String.valueOf(itemCount3));
            }
            countP3 = paket3 * itemCount3;
            setTotalPrice();
        });
    }

    private void setPaket4() {
        imageAdd4.setOnClickListener(v -> {
            itemCount4 = itemCount4 + 1;
            tvPaket4.setText(String.valueOf(itemCount4));
            countP4 = paket4 * itemCount4;
            setTotalPrice();
        });

        imageMinus4.setOnClickListener(v -> {
            if (itemCount4 > 0) {
                itemCount4 = itemCount4 - 1;
                tvPaket4.setText(String.valueOf(itemCount4));
            }
            countP4 = paket4 * itemCount4;
            setTotalPrice();
        });
    }

    private void setPaket5() {
        imageAdd5.setOnClickListener(v -> {
            itemCount5 = itemCount5 + 1;
            tvPaket5.setText(String.valueOf(itemCount5));
            countP5 = paket5 * itemCount5;
            setTotalPrice();
        });

        imageMinus5.setOnClickListener(v -> {
            if (itemCount5 > 0) {
                itemCount5 = itemCount5 - 1;
                tvPaket5.setText(String.valueOf(itemCount5));
            }
            countP5 = paket5 * itemCount5;
            setTotalPrice();
        });
    }

    private void setPaket6() {
        imageAdd6.setOnClickListener(v -> {
            itemCount6 = itemCount6 + 1;
            tvPaket6.setText(String.valueOf(itemCount6));
            countP6 = paket6 * itemCount6;
            setTotalPrice();
        });

        imageMinus6.setOnClickListener(v -> {
            if (itemCount6 > 0) {
                itemCount6 = itemCount6 - 1;
                tvPaket6.setText(String.valueOf(itemCount6));
            }
            countP6 = paket6 * itemCount6;
            setTotalPrice();
        });
    }

    private void setPaket7() {
        imageAdd7.setOnClickListener(v -> {
            itemCount7 = itemCount7 + 1;
            tvPaket7.setText(String.valueOf(itemCount7));
            countP7 = paket7 * itemCount7;
            setTotalPrice();
        });

        imageMinus7.setOnClickListener(v -> {
            if (itemCount7 > 0) {
                itemCount7 = itemCount7 - 1;
                tvPaket7.setText(String.valueOf(itemCount7));
            }
            countP7 = paket7 * itemCount7;
            setTotalPrice();
        });
    }
    private void setPaket8() {
        imageAdd8.setOnClickListener(v -> {
            itemCount8 = itemCount8 + 1;
            tvPaket8.setText(String.valueOf(itemCount8));
            countP8 = paket8 * itemCount8;
            setTotalPrice();
        });

        imageMinus8.setOnClickListener(v -> {
            if (itemCount8 > 0) {
                itemCount8 = itemCount8 - 1;
                tvPaket8.setText(String.valueOf(itemCount8));
            }
            countP8 = paket8 * itemCount8;
            setTotalPrice();
        });
    }
    private void setPaket9() {
        imageAdd9.setOnClickListener(v -> {
            itemCount9 = itemCount9 + 1;
            tvPaket9.setText(String.valueOf(itemCount9));
            countP9 = paket9 * itemCount9;
            setTotalPrice();
        });

        imageMinus9.setOnClickListener(v -> {
            if (itemCount9 > 0) {
                itemCount9 = itemCount9 - 1;
                tvPaket9.setText(String.valueOf(itemCount9));
            }
            countP9 = paket9 * itemCount9;
            setTotalPrice();
        });
    }
    private void setPaket10() {
        imageAdd10.setOnClickListener(v -> {
            itemCount10 = itemCount10 + 1;
            tvPaket10.setText(String.valueOf(itemCount10));
            countP10 = paket10 * itemCount10;
            setTotalPrice();
        });

        imageMinus10.setOnClickListener(v -> {
            if (itemCount10 > 0) {
                itemCount10 = itemCount10 - 1;
                tvPaket10.setText(String.valueOf(itemCount10));
            }
            countP10 = paket10 * itemCount10;
            setTotalPrice();
        });
    }
    private void setPaket11() {
        imageAdd11.setOnClickListener(v -> {
            itemCount11 = itemCount11 + 1;
            tvPaket11.setText(String.valueOf(itemCount11));
            countP11 = paket11 * itemCount11;
            setTotalPrice();
        });

        imageMinus11.setOnClickListener(v -> {
            if (itemCount11 > 0) {
                itemCount11 = itemCount11 - 1;
                tvPaket11.setText(String.valueOf(itemCount11));
            }
            countP11 = paket11 * itemCount11;
            setTotalPrice();
        });
    }
    private void setPaket12() {
        imageAdd12.setOnClickListener(v -> {
            itemCount12 = itemCount12 + 1;
            tvPaket12.setText(String.valueOf(itemCount12));
            countP12 = paket12 * itemCount12;
            setTotalPrice();
        });

        imageMinus12.setOnClickListener(v -> {
            if (itemCount12 > 0) {
                itemCount12 = itemCount12 - 1;
                tvPaket12.setText(String.valueOf(itemCount12));
            }
            countP12 = paket12 * itemCount12;
            setTotalPrice();
        });
    }

    private void setTotalPrice() {
        totalItems = itemCount1 + itemCount2 + itemCount3 + itemCount4 + itemCount5 + itemCount6 +
                itemCount7 + itemCount8 + itemCount9 + itemCount10 + itemCount11 + itemCount12;
        totalPrice = countP1 + countP2 + countP3 + countP4 + countP5 + countP6 +
                countP7 + countP8 + countP9 + countP10 + countP11 + countP12;

        tvJumlahPorsi.setText(totalItems + " items");
        tvTotalPrice.setText(FunctionHelper.rupiahFormat(totalPrice));
    }

    private void setInputData() {
        btnCheckout.setOnClickListener(v -> {
            if (totalItems == 0 || totalPrice == 0) {
                Toast.makeText(OrderActivity2.this, "Ups, pilih menu makanan dulu!",
                        Toast.LENGTH_SHORT).show();
            } else if (totalItems < 2) {
                Toast.makeText(OrderActivity2.this, "Ups, minimal 2 pesanan!",
                        Toast.LENGTH_SHORT).show();
            } else {
                orderViewModel.addDataOrder(strTitle, totalItems, totalPrice);
                Toast.makeText(OrderActivity2.this,
                        "Yeay! Pesanan Anda sedang diproses, cek di menu riwayat ya!",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    public void setStatusbar() {
        if (Build.VERSION.SDK_INT < 21) {
            setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, true);
        }
        if (Build.VERSION.SDK_INT >= 19) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                        View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            }
        }
        if (Build.VERSION.SDK_INT >= 21) {
            setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
    }

    public static void setWindowFlag(@NonNull Activity activity, final int bits, boolean on) {
        Window window = activity.getWindow();
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        if (on) {
            layoutParams.flags |= bits;
        } else {
            layoutParams.flags &= ~bits;
        }
        window.setAttributes(layoutParams);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}