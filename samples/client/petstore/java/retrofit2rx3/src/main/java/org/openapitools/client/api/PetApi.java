package org.openapitools.client.api;

import org.openapitools.client.CollectionFormats.*;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Completable;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.MultipartBody;

import java.io.File;
import org.openapitools.client.model.ModelApiResponse;
import org.openapitools.client.model.Pet;
import java.util.Set;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface PetApi {
  /**
   * Add a new pet to the store
   * 
   * @param body Pet object that needs to be added to the store (required)
   * @return Completable
   */
  @Headers({
    "Content-Type:application/json"
  })
  @HTTP(method = "POST", path = "pet", hasBody = true)
  Completable addPet(
    @retrofit2.http.Body Pet body
  );

  /**
   * Deletes a pet
   * 
   * @param petId Pet id to delete (required)
   * @param apiKey  (optional)
   * @return Completable
   */
  @HTTP(method = "DELETE", path = "pet/{petId}")
  Completable deletePet(
    @retrofit2.http.Path("petId") Long petId, @retrofit2.http.Header("api_key") String apiKey
  );

  /**
   * Finds Pets by status
   * Multiple status values can be provided with comma separated strings
   * @param status Status values that need to be considered for filter (required)
   * @return Observable&lt;List&lt;Pet&gt;&gt;
   */
  @HTTP(method = "GET", path = "pet/findByStatus")
  Observable<List<Pet>> findPetsByStatus(
    @retrofit2.http.Query("status") CSVParams status
  );

  /**
   * Finds Pets by tags
   * Multiple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.
   * @param tags Tags to filter by (required)
   * @return Observable&lt;Set&lt;Pet&gt;&gt;
   * @deprecated
   */
  @Deprecated
  @HTTP(method = "GET", path = "pet/findByTags")
  Observable<Set<Pet>> findPetsByTags(
    @retrofit2.http.Query("tags") CSVParams tags
  );

  /**
   * Find pet by ID
   * Returns a single pet
   * @param petId ID of pet to return (required)
   * @return Observable&lt;Pet&gt;
   */
  @HTTP(method = "GET", path = "pet/{petId}")
  Observable<Pet> getPetById(
    @retrofit2.http.Path("petId") Long petId
  );

  /**
   * Update an existing pet
   * 
   * @param body Pet object that needs to be added to the store (required)
   * @return Completable
   */
  @Headers({
    "Content-Type:application/json"
  })
  @HTTP(method = "PUT", path = "pet", hasBody = true)
  Completable updatePet(
    @retrofit2.http.Body Pet body
  );

  /**
   * Updates a pet in the store with form data
   * 
   * @param petId ID of pet that needs to be updated (required)
   * @param name Updated name of the pet (optional)
   * @param status Updated status of the pet (optional)
   * @return Completable
   */
  @retrofit2.http.FormUrlEncoded
  @HTTP(method = "POST", path = "pet/{petId}")
  Completable updatePetWithForm(
    @retrofit2.http.Path("petId") Long petId, @retrofit2.http.Field("name") String name, @retrofit2.http.Field("status") String status
  );

  /**
   * uploads an image
   * 
   * @param petId ID of pet to update (required)
   * @param additionalMetadata Additional data to pass to server (optional)
   * @param _file file to upload (optional)
   * @return Observable&lt;ModelApiResponse&gt;
   */
  @retrofit2.http.Multipart
  @HTTP(method = "POST", path = "pet/{petId}/uploadImage")
  Observable<ModelApiResponse> uploadFile(
    @retrofit2.http.Path("petId") Long petId, @retrofit2.http.Part("additionalMetadata") String additionalMetadata, @retrofit2.http.Part MultipartBody.Part _file
  );

  /**
   * uploads an image (required)
   * 
   * @param petId ID of pet to update (required)
   * @param requiredFile file to upload (required)
   * @param additionalMetadata Additional data to pass to server (optional)
   * @return Observable&lt;ModelApiResponse&gt;
   */
  @retrofit2.http.Multipart
  @HTTP(method = "POST", path = "fake/{petId}/uploadImageWithRequiredFile")
  Observable<ModelApiResponse> uploadFileWithRequiredFile(
    @retrofit2.http.Path("petId") Long petId, @retrofit2.http.Part MultipartBody.Part requiredFile, @retrofit2.http.Part("additionalMetadata") String additionalMetadata
  );

}
