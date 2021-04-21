package com.febrijuniardi.belajarapic1.services;

import com.febrijuniardi.belajarapic1.model.PhotoData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetService {
    @GET("/photos")
    Call<List<PhotoData>>getAllPhotos();
}
