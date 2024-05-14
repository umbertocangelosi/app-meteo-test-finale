import React from 'react';

export function Footer() {
  return (
    <footer className="footer bg-dark py-3 ">
      <div className="container-xl">
        <div className="row">
          <div className="col-lg-4">
            <h5 className="text-light">Company</h5>
            <ul className="list-unstyled text-muted">
              <li>About Us</li>
              <li>Our Team</li>
              <li>Careers</li>
              <li>Blog</li>
            </ul>
          </div>
          <div className="col-lg-4">
            <h5 className="text-light">Products</h5>
            <ul className="list-unstyled text-muted">
              <li>Product 1</li>
              <li>Product 2</li>
              <li>Product 3</li>
              <li>Product 4</li>
            </ul>
          </div>
          <div className="col-lg-4">
            <h5 className="text-light">Contact Us</h5>
            <ul className="list-unstyled text-muted">
              <li>Email: info@example.com</li>
              <li>Phone: +123456789</li>
              <li>Address: 123 Street, City</li>
            </ul>
          </div>
        </div>
        <hr className="my-4 border-light" />
        <div className="row">
          <div className="col-lg-6">
            <p className="text-muted mb-0">&copy; 2024 Company Name. All rights reserved.</p>
          </div>
          <div className="col-lg-6">
            <ul className="list-inline mb-0 text-end">
              <li className="list-inline-item"><a href="#" className="text-light">Terms of Use</a></li>
              <li className="list-inline-item"><a href="#" className="text-light">Privacy Policy</a></li>
            </ul>
          </div>
        </div>
      </div>
    </footer>
  );
}
