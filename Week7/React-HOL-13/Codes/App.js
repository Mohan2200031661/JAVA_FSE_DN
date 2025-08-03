// src/App.js
import React, { useState } from 'react';
import './App.css';

// Import data
import { books } from './bookdata';
import { posts } from './blogdata';
import { courses } from './coursedata';

// Import components
import BookDetails from './BookDetails';
import BlogDetails from './BlogDetails';
import CourseDetails from './CourseDetails';

function App() {
  // State to manage visibility of each component
  const [showBooks, setShowBooks] = useState(true);
  const [showBlogs, setShowBlogs] = useState(true);
  const [showCourses, setShowCourses] = useState(true);

  return (
      <div className="App">
        <h1>Blogger App</h1>
        <div className="controls">
          <button onClick={() => setShowCourses(!showCourses)}>
            {showCourses ? 'Hide' : 'Show'} Courses
          </button>
          <button onClick={() => setShowBooks(!showBooks)}>
            {showBooks ? 'Hide' : 'Show'} Books
          </button>
          <button onClick={() => setShowBlogs(!showBlogs)}>
            {showBlogs ? 'Hide' : 'Show'} Blogs
          </button>
        </div>
        <div className="container">
          {/* Method 1: Inline If with Logical && Operator */}
          {showCourses && (
              <div className="section">
                <CourseDetails courses={courses} />
              </div>
          )}

          {/* Method 2: Element Variables (demonstrated conceptually) */}
          {showBooks && (
              <div className="section">
                <BookDetails books={books} />
              </div>
          )}

          {/* Method 3: Ternary Operator (can also be used) */}
          {showBlogs ? (
              <div className="section">
                <BlogDetails posts={posts} />
              </div>
          ) : null}
        </div>
      </div>
  );
}

export default App;