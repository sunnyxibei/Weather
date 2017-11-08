package com.stone.weather.view

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import com.stone.weather.R
import com.stone.weather.domain.ForecastList
import com.stone.weather.domain.ForecastModel

/**
 * 适配器
 * Created by jiayuanbin on 2017/8/30.
 */
class MainAdapter(private var mContext: Context, private val forecastList: ForecastList
                  , private val itemClick: (ForecastModel) -> Unit) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val inflate = LayoutInflater.from(mContext).inflate(R.layout.item_layout, parent, false)
        return ViewHolder(inflate, itemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bindForecast(forecastList[position])
    }

    override fun getItemCount(): Int {
        return forecastList.size()
    }

    class ViewHolder(itemView: View, private val itemClick: (ForecastModel) -> Unit)
        : RecyclerView.ViewHolder(itemView) {
        private var imageViewIcon: ImageView? = itemView.findViewById(R.id.icon)
        var textViewDate: TextView = itemView.findViewById(R.id.date)
        var textViewDesc: TextView = itemView.findViewById(R.id.description)
        var textViewMax: TextView = itemView.findViewById(R.id.maxTemperature)
        var textViewMin: TextView = itemView.findViewById(R.id.minTemperature)

        fun bindForecast(forecastModel: ForecastModel) {
            with(forecastModel) {
                Picasso.with(itemView.context).load(iconUrl).into(imageViewIcon)
                textViewDate.text = date
                textViewDesc.text = description
                textViewMax.text = "$high"
                textViewMin.text = "$low"
                itemView.setOnClickListener { itemClick(this) }
            }
        }
    }

}