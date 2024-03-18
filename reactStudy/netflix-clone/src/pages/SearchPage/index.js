import React, {useEffect, useState} from 'react'
import { useLocation } from 'react-router'
import axios from '../../api/axios';
import './SearchPage.css';

export default function SearchPage() {
  
  const [searchResults, setSearchResults] = useState([]); // [1]
  const useQuery = () => {
    return new URLSearchParams(useLocation().search);
  }

  let query = useQuery();
  const searchTerm = query.get("q");

  useEffect(() => {
    if(searchTerm) {
      fetchSearchMovie(searchTerm);
    }
  }, [searchTerm]);

  const fetchSearchMovie = async(searchTerm) => {
    try {
      const request = await axios.get(`/search/multi?include_adult=false&query=${searchTerm}`)

      setSearchResults(request.data.results);
    } catch (error) {
      console.log("error", error)
    }
  }

  // 검색 결과 존재할 경우
  const renderSearchResults = () => {
    return searchResults.length > 0 ? (
      <section className="search-container">
        {searchResults.map((movie) => {
          if(movie.backdrop_path !== null && movie.media_type !== "person") {
            const movieImageUrl = "https://image.tmdb.org/t/p/w500" + movie.backdrop_path;
            return (
              <div className="movie">
                <div className="movie__column-poster">
                  <img src={movieImageUrl} alt="movie" className="movie__poster"/>
                </div>
              </div>
            )
          }
        })}
      </section>
    ) : (
      <section className="no-results">
        <div className="no-results__text">
          <p>
            찾고자 하는 검색어 "{searchTerm}"에 대한 검색 결과가 없습니다.
          </p>
        </div>

      </section>
    )
  }
  
  return renderSearchResults();
}
