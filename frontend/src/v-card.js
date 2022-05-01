import { html, css, LitElement } from 'lit';
import "@vaadin/vaadin-button"
export class VCard extends LitElement {
  static get styles() {
    return css`
    * {
        margin: 0;
        padding: 0;
        font-family: Avenir, Helvetica, Arial, sans-serif;
        -webkit-font-smoothing: antialiased;
        -moz-osx-font-smoothing: grayscale;
        color: #2c3e50;
    }
    .flex-header {
        display: flex;
        align-items: center;
        padding: 1em;
    }
    .mx-auto {
        margin-left: auto;
        margin-right: auto;
    }
    .container {
        background-color: white;
        width: 350px;
        border-style: solid; 
        border-width: 1px;
        border-radius: 8px;
        border-color: rgb(192, 192, 192);
        box-shadow: 20px 20px 15px -12px rgb(0 0 0 / 25%);
    }
    .avatar {
      vertical-align: middle;
      width: 50px;
      height: 50px;
      border-radius: 50%;
    }
    .avatar:hover {
      box-shadow: 0 0 2px 1px rgba(0, 140, 186, 0.5);
    }
    .header-text {
        text-align: left;
        padding-left: 1em;
    }
    .span-2 {
        grid-column: span 2 / span 2;
    }
    .supporting-text {
        text-align: justify;
        padding: 1em;
        font-size: 0.875rem;
        line-height: 1.25rem;
        max-height: 4rem;
        overflow: hidden !important;
    }
    .main-image {
        width:100%;
        height:200px;
        object-fit: cover;
    }
    .grid {
        display: grid;
        grid-template-columns: repeat(2, 1fr);
        grid-gap: 1rem;
        padding: 1em;
    }
    .flex-icons {
        display: flex;
        justify-content: space-evenly;
    }
    svg {
        width: 1.5rem;
        height: 1.5em;
        cursor: pointer;
    }

    #buttons > * {
        border: none;
        color: #2563eb;
        font-weight: 600;
        text-decoration: underline;
        padding: 0.25rem; 
        border-radius: 0.25rem; 
        font-size: 0.875rem; 
        line-height: 1.25rem;
        cursor: pointer;
    }
    #buttons > *:hover {
        color: #1e40af;
    }
        `;
  }
  static get properties() {
    return {
      thumbnail: { type: String },
      headertext: { type: String },
      subhead: {type: String},
      media: {type: String},
      supporttext: {type: String},
    };
  }
  constructor() {
    super();
  }
  showThumbImage() {
    if (this.thumbnail) {
      return html `<img class="avatar" src="${this.thumbnail}" alt="avatar">`
    }
  }
  showMediaImage() {
    if(this.media) {
      return html `<img class="main-image" src="${this.media}" alt="media">`
    }
  }
  render() {
    return html`
      <div class="container mx-auto">
      <div class="flex-header span-2">
        <div>
            ${this.showThumbImage()}
        </div>
        <div class="header-text">
            <h2>${this.headertext}</h2>
            <p>${this.subhead}</p>
        </div>
      </div>
      <div class="span-2">
          ${this.showMediaImage()}
      </div>
      <div class="span-2 supporting-text">
          <p>${this.supporttext}</p>
      </div>
      <div class="grid">
          <div id="buttons"></div>
          <div class="flex-icons">
            <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6" fill="none" viewBox="0 0 24 24" stroke="currentColor" stroke-width="2">
                <path stroke-linecap="round" stroke-linejoin="round" d="M4.318 6.318a4.5 4.5 0 000 6.364L12 20.364l7.682-7.682a4.5 4.5 0 00-6.364-6.364L12 7.636l-1.318-1.318a4.5 4.5 0 00-6.364 0z" />
            </svg>
            <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6" fill="none" viewBox="0 0 24 24" stroke="currentColor" stroke-width="2">
                <path stroke-linecap="round" stroke-linejoin="round" d="M8.684 13.342C8.886 12.938 9 12.482 9 12c0-.482-.114-.938-.316-1.342m0 2.684a3 3 0 110-2.684m0 2.684l6.632 3.316m-6.632-6l6.632-3.316m0 0a3 3 0 105.367-2.684 3 3 0 00-5.367 2.684zm0 9.316a3 3 0 105.368 2.684 3 3 0 00-5.368-2.684z" />
            </svg>
          </div>
      </div>
  </div>
    `;
  }
}

window.customElements.define('v-card', VCard);