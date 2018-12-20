package com.burakdemir.multipleviewholder.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.burakdemir.multipleviewholder.Model.Call;
import com.burakdemir.multipleviewholder.Model.Sms;
import com.burakdemir.multipleviewholder.R;

import java.util.ArrayList;
import java.util.List;

// Burada her iki veri türünü ortak bir object dizisinde tuttum
public class CallSmsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final static int TYPE_CALL = 1;
    private final static int TYPE_SMS = 2;

    private List<Object> callSmsList = new ArrayList();

    private Context context;

    LayoutInflater inflater;

    public CallSmsAdapter(Context context, List<Object> callSmsList){

        this.context = context;
        this.callSmsList = callSmsList;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getItemCount() {

        return callSmsList.size();
    }

    // List içerisinde hem Call hem de Sms türünde sınıflar mevcut (ikiside Object)
    // her bir position değeri için çeşitli kontroller yapıp istediğim değeri gönderebilirim position zaten parametre olarak geliyor
    // gönderdiğim değeri de onCreateViewHolder'da yakalayıp viewType ile istediğim şekilde layout koyabilirim

    // Her bir position değeri için buradan dönecek değere göre onCreateView'de istediğimiz layout'u koyabiliyoruz
    // 0.index için şu değeri dön -> onCreateViewHolder'da dönen değere göre layout oluşturursun böylece customize olur
    @Override
    public int getItemViewType(int position) {

        if (callSmsList.get(position) instanceof Call) {

            return TYPE_CALL;
        }
        else if (callSmsList.get(position) instanceof Sms) {

            return TYPE_SMS;
        }
        return 0;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v;
        RecyclerView.ViewHolder holder;

        switch (viewType){

            case TYPE_CALL:
                v = inflater.inflate(R.layout.call_feed, parent, false);
                holder = new CallViewHolder(v);
                break;

            case TYPE_SMS:
                v = inflater.inflate(R.layout.sms_feed, parent, false);
                holder=new SMSViewHolder(v);
                break;

            default:
                holder=null;
                break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {

        int viewType=holder.getItemViewType();

        switch (viewType){

            case TYPE_CALL:

                ((CallViewHolder)holder).tvCallerName.setText(((Call)callSmsList.get(position)).getCallerName());
                ((CallViewHolder)holder).tvCallTime.setText(((Call)callSmsList.get(position)).getCallTime());
                break;

            case TYPE_SMS:

                ((SMSViewHolder)holder).tvSenderName.setText(((Sms)callSmsList.get(position)).getSenderName());
                ((SMSViewHolder)holder).tvSmsContent.setText(((Sms)callSmsList.get(position)).getSmsContent());
                ((SMSViewHolder)holder).tvSmsTime.setText(((Sms)callSmsList.get(position)).getSmsTime());
                break;
        }
    }

    // Call View Holder
    public class CallViewHolder extends RecyclerView.ViewHolder {

        private TextView tvCallerName;
        private TextView tvCallTime;

        public CallViewHolder(View itemView) {
            super(itemView);

            tvCallerName = itemView.findViewById(R.id.tvCallerName);
            tvCallTime = itemView.findViewById(R.id.tvCallTime);
        }
    }

    // Sms View Holder
    public class SMSViewHolder extends RecyclerView.ViewHolder {

        private TextView tvSenderName;
        private TextView tvSmsContent;
        private TextView tvSmsTime;

        public SMSViewHolder(View itemView) {
            super(itemView);

            tvSenderName = itemView.findViewById(R.id.tvSenderName);
            tvSmsContent = itemView.findViewById(R.id.tvSmsContent);
            tvSmsTime = itemView.findViewById(R.id.tvSmsTime);
        }
    }
}

