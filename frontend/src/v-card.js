import { html, css, LitElement } from 'lit';

export class VCard extends LitElement {
  static get styles() {
    return css`
    * {
        margin: 0;
        padding: 0;
        font-family: 'Noto Sans JP', sans-serif;
        color: #2c3e50;
    }
    .flex {
        display: flex;
        align-items: center;
    }
    .container {
        border-bottom-left-radius: 15px;
        border-bottom-right-radius: 15px;
        border-color: rgb(192, 192, 192);
        box-shadow: 0 0 20px 8px #d0d0d0;
    }
    .container > * {
      padding: 1em;
    }
    .container > .no-padding {
      padding: 0;
    }
    .container-width {
      width: 400px;
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
    .supporting-text {
        text-align: justify;
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
    svg {
        width: 1.5rem;
        height: 1.5em;
        cursor: pointer;
    }
    p {
        font-size: 0.875rem;
        line-height: 1.25rem;
    }
    .fill-svg {
      fill: currentColor;
    }
    .space-between {
      justify-content: space-between;
    }
    #buttons > * {
        border: none;
        color: #2563eb;
        font-weight: 600;
        font-size: 0.875rem; 
        cursor: pointer;
    }
    #buttons > *:hover {
        color: #1e40af;
    }
    @media only screen and (max-width:480px) {
        .container-width {
          width: 100%;
        }
    }
    @media only screen and (min-width: 300px) {
      svg:first-child {
        margin-right: 1rem;
      }
      #buttons > * {
        margin-right: 1rem;
      }
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
  showHeader() {
    if(this.thumbnail || this.headertext || this.subhead) {
        return html `<div class="flex">
        <div>
            ${this.showThumbImage()}
        </div>
        <div class="header-text">
            <h3>${this.headertext}</h3>
            <p>${this.subhead}</p>
        </div>
      </div>`;
    }
  }
  showSupport() {
    if(this.supporttext) {
      return html `<div class="supporting-text">
                      <p>${this.supporttext}</p>
                  </div>`;
    }
  }
  like() {
    this.shadowRoot.getElementById('likeBtn').classList.toggle('fill-svg');
  }
  share() {
    window.alert("You shared this card.");
  }
  render() {
    return html`
      <div class="container container-width">
          ${this.showHeader()}
      <div class="no-padding">
          ${this.showMediaImage()}
      </div>
          ${this.showSupport()}
      <div class="flex space-between">
          <div id="buttons"></div>
          <div>
            <svg id="likeBtn" @click = "${this.like}" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor" stroke-width="2">
                <path stroke-linecap="round" stroke-linejoin="round" d="M4.318 6.318a4.5 4.5 0 000 6.364L12 20.364l7.682-7.682a4.5 4.5 0 00-6.364-6.364L12 7.636l-1.318-1.318a4.5 4.5 0 00-6.364 0z" />
            </svg>
            <svg id="shareBtn" @click="${this.share}" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor" stroke-width="2">
                <path stroke-linecap="round" stroke-linejoin="round" d="M8.684 13.342C8.886 12.938 9 12.482 9 12c0-.482-.114-.938-.316-1.342m0 2.684a3 3 0 110-2.684m0 2.684l6.632 3.316m-6.632-6l6.632-3.316m0 0a3 3 0 105.367-2.684 3 3 0 00-5.367 2.684zm0 9.316a3 3 0 105.368 2.684 3 3 0 00-5.368-2.684z" />
            </svg>
          </div>
      </div>
  </div>
    `;
  }
}

window.customElements.define('v-card', VCard);